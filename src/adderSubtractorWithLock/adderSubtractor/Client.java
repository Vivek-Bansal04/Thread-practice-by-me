package adderSubtractorWithLock.adderSubtractor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) throws InterruptedException {
// we did synchronized over the whole count object but there can be a case where we only want to lock
// value as there can be different values of object
// in this case I have to apply lock on every side where I want to change a value
// if i remove a lock from lets say adder or subtractor then again race condition will occur
// benefit of lock over synchronized keyword is that for every type I can have another lock
        // as in case of BOOK MY SHOW i can have lock over particular seat and not on a full hall

        Count count = new Count();

        ExecutorService executorService = Executors.newCachedThreadPool();

//        to learn another way in case lets say concurrency not handled by external library
        // and we have to handle it at client side
        Lock lockForValue1 = new ReentrantLock();
        Lock lockForValue2 = new ReentrantLock();
        Adder adder = new Adder(count,lockForValue1,lockForValue2);
        Subtractor subtractor = new Subtractor(count,lockForValue1,lockForValue2);

        executorService.execute(adder);
        executorService.execute(subtractor);

        executorService.shutdown();
        executorService.awaitTermination(5L, TimeUnit.SECONDS);

        System.out.println(count.get());
        System.out.println("Something");

    }
}
