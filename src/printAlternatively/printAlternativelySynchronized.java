package printAlternatively;

public class printAlternativelySynchronized {

    public static void main(String[] args) {

        //print odd number and even numbers concurrently
        SharedObject sharedObject = new SharedObject();

        Thread thread3 = new Thread(() -> {
            sharedObject.fillValues();
        });

        Thread thread1 = new Thread(() -> {
            sharedObject.printOddNumbers();
        });

        Thread thread2 = new Thread(() -> {
            sharedObject.printEvenNumbers();
        });

        thread3.start();

        try{
            // to ensure thread 1 and 2 only start executing once thread 3 is completed
            thread3.join();
        }catch (InterruptedException e){

        }

        thread1.start();
        thread2.start();

    }

    static class SharedObject{
        int arr[] = new int[100];
        int val2 = 1;


        private void fillValues(){
            for(int i=0;i<arr.length;i++){
                arr[i] = val2;
                val2++;
            }
//            for(int i=0;i< arr.length;i++){
//                System.out.println(arr[i]);
//            }
        }
        private int value = 0;

        public synchronized void increment(){
            while(value<20){
                value++;
                System.out.println(value);
            }
        }

//        public synchronized void printOddNumbers(){
//            for(int i=0;i< arr.length;i++){
//                if((arr[i]%2)!=0){
//                    System.out.println(arr[i]);
//                }
//                try{
//                    //it will release object monitor lock so printEvenNumber will acquire lock
//                    wait(100);
//                }catch (Exception e){
//
//                }
//
//            }
//        }
//
//        public synchronized void printEvenNumbers(){
//            for(int i=0;i< arr.length;i++){
//                if((arr[i]%2)==0){
//                    System.out.println(arr[i]);
//                }
//                try{
//                    //so when I am using wait(100) it release lock and will start working again
//                    // after 100 if we don't call any notify method
//                    wait(100);
//                }catch (Exception e){
//
//                }
//
//            }
//        }


        //impl without using synchronized
        public synchronized void printOddNumbers(){
            for(int i=0;i< arr.length;i++){
                if((arr[i]%2)!=0){
                    System.out.println(arr[i]);
                    notify();
                    try{
                        wait();
                    }catch (Exception e){
                    }
                }

            }
        }

        public synchronized void printEvenNumbers(){
            for(int i=0;i< arr.length;i++){
                if((arr[i]%2)==0){
                    System.out.println(arr[i]);
                    notify();
                    try{
                        wait();
                    }catch (Exception e){
                    }
                }
            }
        }

        public synchronized int getValue() {
            return value;
        }
    }


}
