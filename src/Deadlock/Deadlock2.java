package Deadlock;

//so question was to simulate a deadlock
// it will also lead to deadlock because static will lead to class level lock so whosoever will acquire the lock
// first won't leave the lock
public class Deadlock2 {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> print1());
        Thread t2 = new Thread(() -> print2());

        t1.start();
        t2.start();
    }

    public static synchronized void print1(){
        try{
            System.out.println("Hello");
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(2000);
        }catch (InterruptedException e){
            System.out.println("Exception 1");
        }
        print2();
    }

    public static synchronized void print2(){
        try {
            System.out.println("World2");
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Exception 1");
        }
        print1();
    }
}
