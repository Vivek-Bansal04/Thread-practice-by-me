package adderSubtractorWithLock.adderSubtractor;

public class Count {
    private int value = 0;
    private int value2 = 0;


    public int get(){
        return value;
    }
     public void set(int i){
        value = i;
     }

    public int getValue2(){
        return value2;
    }
    public void setValue2(int i){
        value2 = i;
    }
}
