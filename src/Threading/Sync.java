package Threading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sync {

    private Object lock1 = new Object();
    private Object lock2 = new Object();
    private Random random = new Random();
    public List<Integer> list1 = new ArrayList<Integer>();
    public List<Integer> list2 = new ArrayList<Integer>();

    public void stageOne() {

        synchronized (lock1) {
            try {
                Thread.sleep(1);
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            list1.add(random.nextInt());
        }
    }

    public synchronized void stageTwo() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            list2.add(random.nextInt());
        }
    }

    public void process() {

        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }

    public void InvokeProcess() throws InterruptedException {
        long start = System.currentTimeMillis();

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                process();
            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                process();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        long end = System.currentTimeMillis();
        System.out.println("totalTime :" + (end - start));
        System.out.println("listOneSize" + list1.size());
        System.out.println("listOneSize" + list2.size());
    }

    public static void main(String args[]) throws InterruptedException {
        Sync sync = new Sync();
        sync.InvokeProcess();
    }
}
