public class printConcurrently {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> printMethod1());
        Thread t2 = new Thread(() -> printMethod2());

        t1.start();
        t2.start();
    }
    private static void printMethod1() {
        for (int i = 0; i < 10; i++) {
            System.out.println( "  Method 1");
            // Sleep for a short time to simulate concurrent execution
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Method for printing "Method 2"
    private static void printMethod2() {
        for (int i = 0; i < 10; i++) {
            System.out.println( "  Method 2");
            // Sleep for a short time to simulate concurrent execution
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
