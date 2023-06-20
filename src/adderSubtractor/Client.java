package adderSubtractor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        //code to create an adder thread and a subtractor thread to do operations on a shared variable
        // solution - so we don't have to return data so I created 2 tasks add and subtract and will use runnable
        // 2. so I created I count object to count as we can't use int as it is a primitive data type and
        // we need a shared object
        // though we are subtracting till 1000 and adding till 1000 still sometimes
        // we are not getting 0 this is called data synchronization mutiple threads share same thing

        Count count = new Count();

        Adder adder = new Adder(count);
        Subtractor subtractor = new Subtractor(count);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(adder);
        executorService.execute(subtractor);

        //once all tasks are done
        executorService.shutdown();
        executorService.awaitTermination(5L, TimeUnit.SECONDS);
        // if I remove synchronized keyword from methods then 0 won't be printed in some cases due to race condition
        //try increasing for loop limit
        System.out.println(count.get());
        System.out.println("Something");

    }
}
