package pl.codewise.internships;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import static org.junit.Assert.*;

public class MessageQueueTest {
    private MessageQueue messageQueue;
    private ThreadPoolExecutor executor;

    @Before
    public void setUp(){
        messageQueue = new MessageQueue();
        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        // Sorry but i have not enough time to write proper tests.
        //I waste too much time think on BoundedPriorityQueue :(
        Runnable taskAdd = new Runnable() {
            @Override
            public void run() {
                // Create radnom Message and push it to Queue
            }
        };
        Runnable taskSnapshot = new Runnable() {
            @Override
            public void run() {
                // Take snapshot of messages not older than 5min
            }
        };
        Runnable taskErrorNumber = new Runnable() {
            @Override
            public void run() {
                //Retrieve number of error message not older than 5min
            }
        };
    }

    @Test
    public void testMaxQueueSize(){

    }

    @Test
    public void testSnapshot(){

    }

    @Test
    public void testAddMessage(){

    }

    @Test
    public void testOverLimitMessage(){

    }

    @Test
    public void testErrorMessageNumber(){

    }
}