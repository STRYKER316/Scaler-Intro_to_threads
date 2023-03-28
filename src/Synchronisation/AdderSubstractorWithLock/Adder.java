package Synchronisation.AdderSubstractorWithLock;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable {
    private Count countVar;
    private Lock lockObj;

    public Adder(Count countVar, Lock lockObj) {
        this.countVar = countVar;
        this.lockObj = lockObj;
    }

    @Override
    public void run() {
//        System.out.println("Starting Adder");

        for (int i = 0; i < 10000; i++) {
            // create the lock before the critical section
            lockObj.lock();
            // critical section
            this.countVar.count += 1;
            // unlock the critical section after execution
            lockObj.unlock();
        }
//        System.out.println("Ending Adder");
    }
}
