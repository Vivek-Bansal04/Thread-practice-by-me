public class Main {
    public static void main(String[] args) {
//        System.out.println("Working on "+ Thread.currentThread().getName());
//
//        //invoking on same thread
//        GreetingGenerator gg = new GreetingGenerator();
//        //gg.run();
//
//        // invoking on different thread
//        Thread t =new Thread(gg);
//        t.start();
//
//        Thread t1 =new Thread(gg);
//        t1.start();
//
//
//        Thread t2 =new Thread(gg);
//        t2.start();
//
//
//        Thread t3 =new Thread(gg);
//        t3.start();
//
//
//        Thread t4 =new Thread(gg);
//        t4.start();
//
//
//        Thread t5 =new Thread(gg);
//        t5.start();



        // print numbers from 1 to 100 parallely
        // first main will create 1st thread then while 1st is created main will keep running and will create 2nd
        // and like this it will be creating threads and thread are running simultaneously doing their work
        // and they are printing in random order because of CPU scheduler
        for(int i = 1;i<=100;i++){
            PrintHundredNumbers print = new PrintHundredNumbers(i);
            Thread t = new Thread(print);
            t.start();
        }

    }
}