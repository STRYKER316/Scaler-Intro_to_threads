package Executor.MergeSort;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws Exception {
        List<Integer> listToSort = List.of(7, 3, 4, 1, 9, 8, 2, 6);


//        MergeSorter mergeSorter = new MergeSorter(listToSort);

        // single threaded only
//        List<Integer> sortedList = mergeSorter.call();
//        System.out.println(sortedList);

        // we need a list as a return value, start() is of void return type
//        Thread sortTask = new Thread((Runnable) mergeSorter);
//        sortTask.start();

        ExecutorService executorService = Executors.newCachedThreadPool();
        MergeSorter mergeSorter = new MergeSorter(listToSort, executorService);

        Future<List<Integer>> sortedArrayFuture = executorService.submit(mergeSorter);

        List<Integer> sortedArray = sortedArrayFuture.get();
        System.out.println(sortedArray);

        executorService.shutdown();
    }
}
