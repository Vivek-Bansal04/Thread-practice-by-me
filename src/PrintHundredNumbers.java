public class PrintHundredNumbers implements Runnable {
    //runnable is basically used to define a task
    int a ;
    public PrintHundredNumbers(int a) {
        this.a = a;
    }

    @Override
    public void run() {
        System.out.println("Print "+a);
    }
}
