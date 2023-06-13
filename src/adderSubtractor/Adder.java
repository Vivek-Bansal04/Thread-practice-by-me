package adderSubtractor;

public class Adder implements Runnable{
    private Count count;

    public Adder(Count count){
        this.count = count;
    }
    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            this.count.value += i;
        }
    }
}
