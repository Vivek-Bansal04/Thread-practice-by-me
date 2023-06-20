package adderSubtractor;

public class Count {
    // to avoid race condition I have added 2 methods
    // and added synchronized keyword so that only 1 thread can access it
    // and synchronized works at object level not method level
    // for any of object inside synchronized method only one thread can access it
    private int value = 0;

    public synchronized void add(int i){
        this.value+= i;
    }

    public synchronized void subtract(int i){
        this.value-=i;
    }

    public int get(){
        return value;
    }
}
