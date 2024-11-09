import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class printOddEven {
    int number = 10;
    int count = 0;

    public synchronized void printEven(){
        while(count<number){
            if(count%2!=0){
                try{
                    wait();
                }catch (InterruptedException e){

                }
            }
            System.out.println(count);
            count++;
            notify();
        }

    }

    public synchronized void printOdd(){
        while(count<number){
            if(count%2==0){
                try{
                    wait();
                }catch (InterruptedException e){

                }
            }
            System.out.println(count);
            count++;
            notify();
        }
    }

    public static void main(String[] args) {
        printOddEven p = new printOddEven();
//        Thread t1 = new Thread(() -> {
//            p.printEven();
//        });
//        Thread t2 = new Thread(() -> {
//            p.printOdd();
//        });
//        t1.start();
//        t2.start();

        ExecutorService e = Executors.newFixedThreadPool(2);
        Runnable r1 = p::printEven;
//        Runnable r2 = () -> p.printOdd();

        e.submit(() -> p.printOdd());
        e.submit(r1);

        //.submit return a future
        //.execute doesnt return anything



    }
}
