package Synchronisation.AdderSubtractorAtomicTypes;

public class Subtractor implements Runnable {
    private Count countVar;

    public Subtractor(Count countVar) {
        this.countVar = countVar;
    }
    @Override
    public void run() {
//        System.out.println("Starting Subtractor");
        for (int i = 0; i < 10000; i++) {
            this.countVar.count.addAndGet(-1);
        }
//        System.out.println("Starting Subtractor");
    }
}
