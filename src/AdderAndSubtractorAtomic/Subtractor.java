package AdderAndSubtractorAtomic;

public class Subtractor implements Runnable{
    private Count count;

    public Subtractor(Count count){
        this.count = count;
    }
    @Override
    public void run() {
        for(int i=0;i<100000;i++){
//            try{
//                Thread.sleep(5L);
//            }catch (Exception e){
//
//            }
            this.count.subtract1();
        }

    }
}
