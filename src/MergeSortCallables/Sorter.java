package MergeSortCallables;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {
    private List<Integer> arrayToSort;
    private ExecutorService executorService;

    public Sorter(List<Integer> arrayToSort,ExecutorService executorService){
        this.arrayToSort = arrayToSort;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() throws Exception {
        if(arrayToSort.size()<=1){
            return arrayToSort;
        }
        int mid = arrayToSort.size()/2;

        List<Integer> leftArrayToSort = new ArrayList<>();
        for(int i=0;i<mid;i++){
            leftArrayToSort.add(arrayToSort.get(i));
        }

        List<Integer> rightArrayToSort = new ArrayList<>();
        for(int i=mid;i<arrayToSort.size();i++){
            rightArrayToSort.add(arrayToSort.get(i));
        }
        //In cached thread we don't have to specify number of threads
        Sorter leftSorter = new Sorter(leftArrayToSort,executorService);
        Sorter rightSorter = new Sorter(rightArrayToSort,executorService);
        // writing here so that sub threads will be created when we will run above program
        Future<List<Integer>> leftSortedArrayFuture = executorService.submit(leftSorter);
        Future<List<Integer>> rightSortedArrayFuture = executorService.submit(rightSorter);
        //code won't stop at above points as futures help us to store data and run in parallel

        List<Integer> sortedArray = new ArrayList<>();
        int i=0;
        int j=0;

        List<Integer> leftSortedArray = leftSortedArrayFuture.get();//code will wait till future is not done
        List<Integer> rightSortedArray = rightSortedArrayFuture.get();

        while(i<leftSortedArray.size() && j<rightSortedArray.size()){
            if(leftSortedArray.get(i) <= rightSortedArray.get(j)){
                sortedArray.add(leftSortedArray.get(i));
                i++;
            }else {
                sortedArray.add(rightSortedArray.get(j));
                j++;
            }
        }

        while (i<leftSortedArray.size()){
            sortedArray.add(leftSortedArray.get(i));
            i++;
        }
        while (j<rightSortedArray.size()){
            sortedArray.add(rightSortedArray.get(j));
            j++;
        }

        return sortedArray;
    }
}
