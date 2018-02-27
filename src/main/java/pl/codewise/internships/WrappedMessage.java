package pl.codewise.internships;


public class WrappedMessage implements Comparable<WrappedMessage>{
    private Message message;
    private long messageCreationTime;


    public WrappedMessage(Message message, Long time){
        this.message = message;
        this.messageCreationTime = time;
    }

    public Message getMessage() {
        return message;
    }

    public long getMessageCreationTime() {
        return messageCreationTime;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        WrappedMessage message = (WrappedMessage) obj;
        return message.messageCreationTime == this.messageCreationTime;
    }

    public int compareTo(WrappedMessage o) {
        return Long.compare(this.messageCreationTime, o.messageCreationTime);
    }
}
