package Deadlock;

//so question was to simulate a deadlock
public class Deadlock {

    public static void main(String[] args) {
        Deadlock d1 = new Deadlock();
        Deadlock d2 = new Deadlock();
        Thread t1 = new Thread(() -> d1.print1(d2));
        Thread t2 = new Thread(() -> d2.print2(d1));

        t1.start();
        t2.start();
    }

    public synchronized void print1(Deadlock d2){
            try{
                System.out.println("Hello");
                Thread.sleep(2000);
            }catch (InterruptedException e){
                System.out.println("Exception 1");
            }
        synchronized (d2){
            System.out.println("hello1");
        }

    }

    public synchronized void print2(Deadlock d1){
            try {
                System.out.println("World2");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Exception 1");
            }


        synchronized (d1){
            System.out.println("World1");

        }


    }
}
