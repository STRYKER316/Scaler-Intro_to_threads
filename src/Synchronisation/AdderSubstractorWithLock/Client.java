package Synchronisation.AdderSubstractorWithLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Count countVar = new Count();
        // create a lock object to share with separate threads
        Lock lockObj = new ReentrantLock();

        // create the tasks
        Adder adderTask = new Adder(countVar, lockObj);
        Subtractor subtractorTask = new Subtractor(countVar, lockObj);

        // start separate threads
        Thread t1 = new Thread(adderTask);
        Thread t2 = new Thread(subtractorTask);

        t1.start();
        t2.start();

        // wait for two threads to finish executing
        t1.join();
        t2.join();

        System.out.println(countVar.count);


    }
}
