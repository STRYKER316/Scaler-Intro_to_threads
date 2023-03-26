package HelloPrinter;

public class Client {
    public static void main(String[] args) {
        System.out.println("Print called from main function printed by thread: " + Thread.currentThread().getName());

        // print something else using a different thread
        GreetingPrinter gP = new GreetingPrinter();
        // directly invoking the method won't start a new thread by itself
        gP.run();


        // we have to explicitly create a new thread
        Thread task1 = new Thread(gP);
        task1.start();

    }
}
