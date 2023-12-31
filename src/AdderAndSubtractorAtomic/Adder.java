package AdderAndSubtractorAtomic;

public class Adder implements Runnable{
    private Count count;

    public Adder(Count count){
        this.count = count;
    }
    @Override
    public void run() {
        for(int i=0;i<100000;i++){
            //so race condition is happening here won't happen when i will use atomicInteger
            this.count.add1();
        }
    }
}
