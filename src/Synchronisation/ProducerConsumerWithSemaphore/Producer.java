package Synchronisation.ProducerConsumerWithSemaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable{
    private Queue<Object> queue;
    private int maxSize;
    private String name;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;

    public Producer(Queue queue, int maxSize, String name, Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.queue = queue;
        this.maxSize = maxSize;
        this.name = name;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        while (true) {
            // get the Producer semaphore lock if available
            try {
                producerSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // critical section
            System.out.println(this.name + " adding an object. Queue size: " + this.queue.size());
            queue.add(new Object());
            // release the Consumer semaphore after producer semaphore is done with its task
            consumerSemaphore.release();
        }
    }
}
