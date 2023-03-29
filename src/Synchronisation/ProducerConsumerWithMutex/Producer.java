package Synchronisation.ProducerConsumerWithMutex;

import java.util.Queue;

public class Producer implements Runnable{
    private Queue<Object> queue;
    private int maxSize;
    private String name;

    public Producer(Queue queue, int maxSize, String name) {
        this.queue = queue;
        this.maxSize = maxSize;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                // critical section
                if (queue.size() < this.maxSize) {

                    System.out.println(this.name + " adding an object. Queue size: " + this.queue.size());
                    queue.add(new Object());
                }
            }
        }
    }
}
