public class GreetingGenerator implements Runnable{
    @Override
    public void run() {
        System.out.println("hello from "+Thread.currentThread().getName());
    }
}
