package Synchronisation.ProducerConsumerWithMutex;

import java.util.Queue;

public class Consumer implements Runnable{
    private Queue<Object> queue;
    private int maxSize;
    private String name;

    public Consumer(Queue queue, int maxSize, String name) {
        this.queue = queue;
        this.maxSize = maxSize;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue)  {
                // critical section
                if (queue.size() > 0) {
                    System.out.println(this.name + " removing an object. Queue size: " + this.queue.size());
                    queue.remove();
                }
            }
        }
    }
}
