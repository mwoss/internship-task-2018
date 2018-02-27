package pl.codewise.internships;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.concurrent.locks.ReentrantLock;

public class MessageQueue implements IMessageQueue {

    private TreeSet<WrappedMessage> messages;
    private final int maxSize = 100;
    private final long maxTime = 1000 * 60 * 5;

    private ReentrantLock lock = new ReentrantLock();

    public MessageQueue(){
        this.messages = new TreeSet<>();
    }

    public void add(Message message) {
        lock.lock();
        try{
            messages.add(wrapMessage(message));
        }
        finally {
            lock.unlock();
        }

    }

    public Snapshot snapshot() {
        lock.lock();
        ArrayList<Message> snapshot = new ArrayList<>();
        try{
            boolean flag = true;
            for(Iterator<WrappedMessage> iterator = messages.descendingIterator(); iterator.hasNext(); ){
                if(snapshot.size() == maxSize)
                    break;

                if (flag && iterator.next().getMessageCreationTime() >= System.currentTimeMillis() - maxTime)
                    snapshot.add(iterator.next().getMessage());
                else{
                    flag = false;
                    iterator.remove();
                }

            }
        }finally {
            lock.unlock();
        }
        return new Snapshot(snapshot);
    }

    public long numberOfErrorMessages() {
        lock.lock();
        int errorMessageNumber = 0;
        try{
            Snapshot snapshot = snapshot();
            for(Message message : snapshot.getMessageSnapshot()){
                if(message.getErrorCode() >= 400)
                    errorMessageNumber++;
            }
        }
        finally {
            lock.unlock();
        }
        return errorMessageNumber;
    }

    private WrappedMessage wrapMessage(Message message){
        return new WrappedMessage(message, System.currentTimeMillis());
    }
}
