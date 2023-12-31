package adderSubtractorWithLock.adderSubtractor;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable{
    private Count count;
    private Lock lockForValue1;
    private Lock lockForValue2;

    public Adder(Count count, Lock lockForValue1,Lock lockForValue2){
        this.count = count;
        this.lockForValue1 = lockForValue1;
        this.lockForValue2 = lockForValue2;
    }
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            lockForValue1.lock();
            int current = count.get();
            int next = current + i;
            count.set(next);
            lockForValue1.unlock();
        }
    }
}
