package Executor.MergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MergeSorter implements Callable<List<Integer>> {
    private List<Integer> arrayToSort;
    private ExecutorService executorService;
    public MergeSorter(List<Integer> arrayToSort, ExecutorService executorService) {
        this.arrayToSort = arrayToSort;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() throws Exception {
        // ------ implement merge sort logic --------
        // base case
        if (arrayToSort.size() <= 1)
            return arrayToSort;

        // else divide the array into two halves
        int mid = (arrayToSort.size()) / 2;

        List<Integer> leftHalf = new ArrayList<>();
        for (int i = 0; i < mid; i++) {
            leftHalf.add(arrayToSort.get(i));
        }
        List<Integer> rightHalf = new ArrayList<>();
        for (int i = mid; i < arrayToSort.size(); i++) {
            rightHalf.add(arrayToSort.get(i));
        }

        // sort the two halves
        MergeSorter leftMergeSorter = new MergeSorter(leftHalf, executorService);
        MergeSorter rightMergeSorter = new MergeSorter(rightHalf, executorService);

//        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<List<Integer>> leftSortedArrayFuture = executorService.submit(leftMergeSorter);
        Future<List<Integer>> rightSortedArrayFuture = executorService.submit(rightMergeSorter);

        // Retrieve and  merge the sorted halves
        List<Integer> leftSortedArray = leftSortedArrayFuture.get();
        List<Integer> rightSortedArray = rightSortedArrayFuture.get();

        List<Integer> sortedArray = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;
        while (p1 < leftSortedArray.size() && p2 < rightSortedArray.size()) {
            if (leftSortedArray.get(p1) < rightSortedArray.get(p2)) {
                sortedArray.add(leftSortedArray.get(p1));
                ++p1;
            } else {
                sortedArray.add(rightSortedArray.get(p2));
                ++p2;
            }
        }
        // add rest of the elements from the remaining array
        while (p1 < leftSortedArray.size()) {
            sortedArray.add(leftSortedArray.get(p1));
            ++p1;
        }
        while (p2 < rightSortedArray.size()) {
            sortedArray.add(rightSortedArray.get(p2));
            ++p2;
        }

        executorService.shutdown();

       return sortedArray;
    }
}
