package Synchronisation.ProducerConsumerWithSemaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{
    private Queue<Object> queue;
    private int maxSize;
    private String name;
    private Semaphore proucerSemaphore;
    private Semaphore consumerSemaphore;

    public Consumer(Queue queue, int maxSize, String name, Semaphore proucerSemaphore, Semaphore consumerSemaphore) {
        this.queue = queue;
        this.maxSize = maxSize;
        this.name = name;
        this.proucerSemaphore = proucerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        while (true) {
            // acquire the consumer semaphore lock if available
            try {
                consumerSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // critical section
            System.out.println(this.name + " removing an object. Queue size: " + this.queue.size());
            queue.remove();
            // release the producer semaphore after consumer semaphore is done
            proucerSemaphore.release();
        }
    }
}
