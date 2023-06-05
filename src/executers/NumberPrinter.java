package executers;

public class NumberPrinter implements Runnable{
    int a;
    public NumberPrinter(int a ) {
        this.a = a;
    }

    @Override
    public void run() {
        System.out.println("Print "+a);
    }
}
