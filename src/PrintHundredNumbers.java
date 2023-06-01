public class PrintHundredNumbers implements Runnable {
    int a ;
    public PrintHundredNumbers(int a) {
        this.a = a;
    }

    @Override
    public void run() {
        System.out.println("Print "+a);
    }
}
