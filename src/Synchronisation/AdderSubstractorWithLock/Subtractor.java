package Synchronisation.AdderSubstractorWithLock;

import java.util.concurrent.locks.Lock;

public class Subtractor implements Runnable {
    private Count countVar;
    private Lock lockObj;

    public Subtractor(Count countVar, Lock lockObj) {
        this.countVar = countVar;
        this.lockObj = lockObj;
    }
    @Override
    public void run() {
//        System.out.println("Starting Subtractor");
        for (int i = 0; i < 10000; i++) {
            // create the lock before the critical section
            lockObj.lock();
            // critical section
            this.countVar.count -= 1;
            // unlock the critical section after execution
            lockObj.unlock();
        }
//        System.out.println("Starting Subtractor");
    }
}
