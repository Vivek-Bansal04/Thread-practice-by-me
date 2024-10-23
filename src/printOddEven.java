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
        Thread t1 = new Thread(() -> {
            p.printEven();
        });
        Thread t2 = new Thread(() -> {
            p.printOdd();
        });
        t1.start();
        t2.start();
    }
}
