package HashMap;

import java.util.HashMap;
import java.util.Map;

public class SynchronizedHashMap<K, V> {
    private final Map<K, V> map = new HashMap<>();

    // Synchronized method for put operation
    public synchronized void put(K key, V value) {
        map.put(key, value);
    }

    // Synchronized method for get operation
    public synchronized V get(K key) {
        return map.get(key);
    }

    // Synchronized method for removing an element
    public synchronized V remove(K key) {
        return map.remove(key);
    }

    // You can also synchronize iteration
    public synchronized void printAll() {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        SynchronizedHashMap<String, String> customMap = new SynchronizedHashMap<String, String>();
        customMap.put("1", "One");
        customMap.put("2", "Two");

        // Accessing the map safely
        customMap.printAll();
    }
}

// only one thread can access any synchronized method at a time. So if one thread is calling the get() method,
// another thread will be blocked even if it's trying to call a different method like put() or remove().
//This is because the synchronized keyword locks the entire object (in this case, the instance of SynchronizedHashMap).
// As a result, no other thread can access any synchronized method on that object until the first thread releases the lock.

// so if interviewer asks to improve performance of this use ReentrantReadWriteLock
