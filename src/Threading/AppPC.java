package Threading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class AppPC {

    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

    public static void main(String args[]) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    producer();
                }
                catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        });
        Thread t3 = new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    consumer();
                }
                catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        });
        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    consumer();
                }
                catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        });
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        
    }

    public static void producer() throws InterruptedException{
        Random rand = new Random();
        while(true){
            Thread.sleep(5000);
           Integer val = rand.nextInt(100);
            queue.put(val);
            System.out.println("value added ++++"+ val+ "by"+Thread.currentThread().getId()+"queue Size"+ queue.size());
        }
    }

    public static void consumer() throws InterruptedException {
        Random rand = new Random();
        while(true){
            
            Integer val = queue.take();
            System.out.println("value taken ---- :"+"by"+Thread.currentThread().getId()+ val +"queue Size"+ queue.size());
            
        }
    }

}
