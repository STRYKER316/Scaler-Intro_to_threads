package HelloPrinter;

public class GreetingPrinter implements Runnable {
    @Override
    public void run() {
        System.out.println("Greetings from thread: " + Thread.currentThread().getName());
    }

    public void doStuff() {
        System.out.println("Hello from thread: " + Thread.currentThread().getName());
    }
}
