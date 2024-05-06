package printAlternatively;

import java.util.concurrent.Semaphore;

public class printAlternativelySemaphores {
    private static Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) {
        Thread helloThread = new Thread(() -> printHello());
        Thread worldThread = new Thread(() -> printWorld());

        helloThread.start();
        worldThread.start();
    }

    private static void printHello() {
        for (int i = 0; i < 10; i++) {
            try {
                semaphore.acquire();
                System.out.println("Hello");
                semaphore.release();
                Thread.sleep(1000);
            }catch (InterruptedException e){

            }
        }
    }

    private static void printWorld()  {
        for (int i = 0; i < 10; i++) {
            try {
                semaphore.acquire();
                System.out.println( "World");
                semaphore.release();
                Thread.sleep(1000);
            }catch (InterruptedException e){

            }

        }
    }
}
