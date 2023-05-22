public class Main {
    public static void main(String[] args) {
        System.out.println("Working on "+ Thread.currentThread().getName());

        //invoking on same thread
        GreetingGenerator gg = new GreetingGenerator();
        //gg.run();

        // invoking on different thread
        Thread t =new Thread(gg);
        t.start();
    }
}