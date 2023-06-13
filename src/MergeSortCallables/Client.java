package MergeSortCallables;

import java.sql.SQLOutput;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> arrayToSort = List.of(5,8,10,1,6,3,9,34,12);
        ExecutorService es = Executors.newCachedThreadPool();
        Sorter sorter = new Sorter(arrayToSort,es);
        Future<List<Integer>> listFuture = es.submit(sorter);
        List<Integer> sortedList = listFuture.get();
        for (Integer i : sortedList){
            System.out.println(i);
        }
    }
}
