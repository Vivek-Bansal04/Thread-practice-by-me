package executers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        for(int i=1;i<=100;i++){
            if(i == 60){
                //WE CAN SEE TASK QUEUE IN DEBUGGER
                // workqueue it will start from 11 as we have assigned 10 threads
                // in pool and those are assigned to threads and these are in queue
                // we can see these threads inside workers
                // numbers are not printed till debugger at "STOP" because main thread is way faster than other threads
                // but if I take large number then some numbers will get printed
                System.out.println("STOP");
            }
            NumberPrinter nP = new NumberPrinter(i);
            service.execute(nP);
        }
    }
}
