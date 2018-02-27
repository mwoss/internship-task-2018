package pl.codewise.internships;

public interface IMessageQueue {

    void add(Message message);

    Snapshot snapshot();

    long numberOfErrorMessages();
}
