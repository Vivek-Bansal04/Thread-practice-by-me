public class printConcurrentlyMThreads {
    //task is to print 1 number 1 by 1 from each thread

    int number = 10;
    int count = 1;
    int turn = 1;


    public synchronized void printNumber(int threadId) {
        while (count < number) {
            while(threadId!=turn){
                try {
                    wait();
                } catch (Exception e) {

                }
            }
            System.out.println(Thread.currentThread().getName());
            System.out.println(count);
            count++;
            turn = (turn%3)+ 1;
            notifyAll();
        }
    }
    public static void main(String[] args) {
        printConcurrentlyMThreads m = new printConcurrentlyMThreads();
        Thread t1 = new Thread(() -> m.printNumber(1));
        Thread t2 = new Thread(() -> m.printNumber(2));
        Thread t3 = new Thread(() -> m.printNumber(3));

        t1.start();
        t2.start();
        t3.start();

    }
}
