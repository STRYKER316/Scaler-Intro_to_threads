package Synchronisation.AdderSubtractorSynchronisedMethod;

public class Adder implements Runnable {
    private Count countVar;

    public Adder(Count countVar) {
        this.countVar = countVar;
    }

    @Override
    public void run() {
//        System.out.println("Starting Adder");

        for (int i = 0; i < 10000; i++) {
            // critical section
            this.countVar.incrementCount(1);

        }
//        System.out.println("Ending Adder");
    }
}
