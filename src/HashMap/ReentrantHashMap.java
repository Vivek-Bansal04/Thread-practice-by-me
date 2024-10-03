package HashMap;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantHashMap<K,V> {
    private final HashMap<K,V> map = new HashMap<>();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void put(K key,V value){
        lock.writeLock().lock();
        try{
            map.put(key,value);
            Thread.sleep(2000);
        }catch (Exception e){

        } finally{
            lock.writeLock().unlock();
        }
    }

    public V get(K key){
        lock.readLock().lock();
        try {
            Thread.sleep(2000);
            return map.get(key);
        }catch (Exception e){

        } finally {
            lock.readLock().unlock();
        }
        return null;
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantHashMap<String, Integer> lockMap = new ReentrantHashMap<String, Integer>();
//        lockMap.put("Raman",1);
//        System.out.println(lockMap.get("Raman"));
//        lockMap.put("Vivek",2);
//        System.out.println(lockMap.get("Vivek"));
//        lockMap.put("Nakul",3);
//        System.out.println(lockMap.get("Nakul"));
//        lockMap.put("Pranav",4);
//        System.out.println(lockMap.get("Pranav"));


        Thread t1 = new Thread(() -> {
            lockMap.put("Raman", 1);
        });
        Thread t2 = new Thread(() -> {
            lockMap.put("Vivek", 2);
        });
        Thread t3 = new Thread(() -> {
            lockMap.put("Nakul", 3);
        });
        Thread t4 = new Thread(() -> {
            lockMap.put("Pranav", 4);
        });
        long startTime = System.currentTimeMillis();
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Wait for all threads to finish put operations
        t1.join();
        t2.join();
        t3.join();
        t4.join();

        long endTime = System.currentTimeMillis();
        System.out.println("time: " + (endTime - startTime));

        long startTime2 = System.currentTimeMillis();
        Thread t5 = new Thread(() -> {
            System.out.println(lockMap.get("Vivek"));
        });
        Thread t6 = new Thread(() -> {
            System.out.println(lockMap.get("Nakul"));
        });
        Thread t7 = new Thread(() -> {
            System.out.println(lockMap.get("Pranav"));
        });
        Thread t8 = new Thread(() -> {
            System.out.println(lockMap.get("Raman"));
        });

        t5.start();
        t6.start();
        t7.start();
        t8.start();

        // Wait for all threads to finish get operations
        t5.join();
        t6.join();
        t7.join();
        t8.join();
        long endTime2 = System.currentTimeMillis();
        System.out.println("time2: " + (endTime2 - startTime2));
//        System.out.println(Thread.currentThread().getName());

    }
}
//main thread completes its execution first and worker threads keep on executing tasks if I don't use joins to wait for task completion
// can be verified using print statements and removing joins

//Multiple readers can acquire the read lock at the same time. This means multiple threads can call get()
// concurrently without blocking each other.
//Only one writer can hold the write lock at any time. If a write operation (put() or remove()) is being executed, all
// other read and write operations are blocked until the write lock is released.
//Writers are given exclusive access, meaning that if a thread holds a write lock, no other thread (reader or writer) can proceed.

//Output

//time: 8025
//        2
//        3
//        4
//        1
//time2: 2000


//to optimize this further we can use a conccurent hashmap where segments are locked