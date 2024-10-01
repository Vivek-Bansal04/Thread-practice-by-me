package Deadlock;

import java.util.concurrent.SynchronousQueue;

public class Deadlock3 {
    private static Deadlock3 d1 = new Deadlock3();
    private static Deadlock3 d2 = new Deadlock3();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> print1());
        Thread t2 = new Thread(() -> print2());

        t1.start();
        t2.start();
    }

    public static void print1(){
        synchronized (d1){
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
    }

    public static synchronized void print2(){
        synchronized (d2){
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
}
