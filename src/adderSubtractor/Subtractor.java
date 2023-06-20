package adderSubtractor;

public class Subtractor implements Runnable{
    private Count count;

    public Subtractor(Count count){
        this.count = count;
    }
    @Override
    public void run() {
//        for(int i=0;i<1000;i++){
//            this.count.value -= i;
//        }
        for(int i=0;i<100;i++){
            try{
                Thread.sleep(5L);
            }catch (Exception e){

            }
            this.count.subtract(i);
        }

    }
}
