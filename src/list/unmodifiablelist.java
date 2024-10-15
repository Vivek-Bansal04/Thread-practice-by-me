package list;

import java.util.ArrayList;
import java.util.List;

//create a read only arraylist without using unmodifiable list
public class unmodifiablelist<E> extends ArrayList<E> {
    private final List<E> list;

    public unmodifiablelist(List<E> arrayList){
        this.list = arrayList;
    }

    @Override
    public boolean add(E e) {
        throw new UnsupportedOperationException("This list is read-only.");
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("This list is read-only.");
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException("This list is read-only.");
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("This list is read-only.");
    }

    @Override
    public E get(int index) {
        return list.get(index);  // Allow read access
    }

    @Override
    public int size() {
        return list.size();  // Allow read access
    }

    public static void main(String[] args) {
        List<String> originalList = new ArrayList<>();
        originalList.add("One");
        originalList.add("Two");

        unmodifiablelist<String> readOnlyList = new unmodifiablelist<>(originalList);

        // This will work
        System.out.println(readOnlyList.get(0));  // Output: "One"

       // This will throw an UnsupportedOperationException
        readOnlyList.add("Three");  // Error: This list is read-only.
    }
}
