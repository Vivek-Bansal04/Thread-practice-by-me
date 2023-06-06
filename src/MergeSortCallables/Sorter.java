package MergeSortCallables;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sorter implements Callable<List<Integer>> {
    private List<Integer> arrayToSort;

    public Sorter(List<Integer> arrayToSort){
        this.arrayToSort = arrayToSort;
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
        ExecutorService executorService = Executors.newCachedThreadPool();
        Sorter leftSorter = new Sorter(leftArrayToSort);
        Sorter rightSorter = new Sorter(rightArrayToSort);

        executorService.submit(leftSorter);
        executorService.submit(rightSorter);

        return null;
    }
}
