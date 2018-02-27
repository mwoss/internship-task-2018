package pl.codewise.internships;

import java.util.ArrayList;

public class Snapshot {
    private ArrayList<Message> messageSnapshot;

    public Snapshot(ArrayList<Message> messages){
        this.messageSnapshot = messages;
    }
    public ArrayList<Message> getMessageSnapshot() {
        return messageSnapshot;
    }
}
