package adderSubtractor;

public class Adder implements Runnable{
    private Count count;

    public Adder(Count count){
        this.count = count;
    }
    @Override
    public void run() {
        //commented as added methods in Count class because of race condition
//        for(int i=0;i<1000;i++){
//            this.count.value += i;
//        }
        for(int i=0;i<100;i++){
            this.count.add(i);
        }
    }
}
