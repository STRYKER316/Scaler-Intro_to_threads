package Synchronisation.AdderSubstractor;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Count countVar = new Count();

        // create the tasks
        Adder adderTask = new Adder(countVar);
        Subtractor subtractorTask = new Subtractor(countVar);

        // start separate threads
        Thread t1 = new Thread(adderTask);
        Thread t2 = new Thread((subtractorTask));

        t1.start();
//        t1.join();

        t2.start();
//        t2.join();

        // wait for two threads to finish executing
        t1.join();
        t2.join();

        System.out.println(countVar.count);


    }
}
