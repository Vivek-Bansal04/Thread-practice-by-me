package AdderAndSubtractorAtomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Count {
//    private int value = 0;
    private AtomicInteger atomicInteger = new AtomicInteger(0);

//    public void add(int i){
//        this.value+= i;
//    }
//
//    public void subtract(int i){
//        this.value-=i;
//    }
//
//    public int get(){
//        return value;
//    }
//
//    public void add1(){
//        //it ensures that no race condition is occured
//        atomicInteger.incrementAndGet();
//        //internally first it gets then add and then set
//        this.value+= 1;
//    }
//
//    public void subtract1(){
//        atomicInteger.decrementAndGet();
//        this.value-= 1;
//    }

    public void add(int i){
        atomicInteger.addAndGet(i);
    }

    public void subtract(int i){
        atomicInteger.addAndGet(-1);
    }

    public int get(){
        return atomicInteger.get();
    }

    public void add1(){
        atomicInteger.incrementAndGet();
    }

    public void subtract1(){
        atomicInteger.decrementAndGet();
    }
}
