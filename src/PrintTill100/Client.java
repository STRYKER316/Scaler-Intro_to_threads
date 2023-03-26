package PrintTill100;

public class Client {
    public static void main(String[] args) {
        System.out.println("Hello printed by: " + Thread.currentThread().getName());

        int range = 100;
        for (int i = 1; i <= range; i++) {
            NumberPrinter pN = new NumberPrinter(i);
            Thread task = new Thread(pN);
            task.start();
        }
    }
}
