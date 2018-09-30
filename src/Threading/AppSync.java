package Threading;

public class AppSync {

    int count;
    public static void main(String args[]) throws InterruptedException {
     AppSync appSync = new AppSync();
     appSync.doWork();
    }
    
    public synchronized void increment(){
        count ++;
    }

    public void doWork() throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10000;i++){
                    increment();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10000;i++){
                    increment();
                }
            }
        });
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
        System.out.println("Count is "+ count);
    }
}
