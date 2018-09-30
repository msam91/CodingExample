package Threading;

public class AppRunnable {

    public static void main(String args[]) throws InterruptedException {
        Thread t1= new Thread(new AppRunner());
        t1.start();
        
        Thread t2 = new Thread(new AppRunner());
        t2.start();
        
        t1.join();
        t2.join();
    }

}

class AppRunner implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
