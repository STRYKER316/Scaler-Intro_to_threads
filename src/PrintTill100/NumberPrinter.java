package PrintTill100;

public class NumberPrinter implements Runnable{
    private final int numToPrint;

    public NumberPrinter(int numToPrint) {
        this.numToPrint = numToPrint;
    }

    @Override
    public void run() {
        System.out.println(this.numToPrint + " printed by: " + Thread.currentThread().getName());
    }
}
