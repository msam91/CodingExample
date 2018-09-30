package Threading;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AppNotifyWait {

    public static void main(String args[]) throws InterruptedException {
        ProducerConsumer pc = new ProducerConsumer();
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    pc.producer();
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
                    pc.consumer();
                }
                catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("completed");

    }

}

class ProducerConsumer {
    private LinkedList<Integer>list = new LinkedList<Integer>();
    private int size = 10;
    private Object lock = new Object();

    public void producer() throws InterruptedException {
        while (true) {
            
            synchronized (lock) {
                System.out.println("producer is running");
                while (list.size()==size) {
                    lock.wait();
                }
                list.addFirst(5);
                lock.notify();
            }
        }
    }

    public void consumer() throws InterruptedException {
        while (true) {
            Thread.sleep(1000);
            synchronized (lock) {
                System.out.println("consumer is running");
                while (list.size()==0) {
                    lock.wait();
                }
                list.removeFirst();
                lock.notify();

            }
        }
    }

}
