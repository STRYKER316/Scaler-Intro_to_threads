package Executor.PrintTill100;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        // create a thread pool with some fixed number of threads
        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        ExecutorService executorService = Executors.newCachedThreadPool();

        // use the thread pool to print the numbers, instead of creating a new thread for each number print
        int range = 100;
        for (int i = 1; i <= range; i++) {
            // check thread pool status
            if (i == 10 || i == 25 || i == 45 || i == 80) {
                System.out.println("Debug");
            }

            NumberPrinter numberPrinter = new NumberPrinter(i);
            executorService.execute(numberPrinter);
        }

        executorService.shutdown();
    }
}
