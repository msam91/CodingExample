package Threading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AppLatch {

    public static void main(String args[]) {
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService executor = Executors.newFixedThreadPool(6);

        for (int i = 0; i < 3; i++) {
            executor.submit(new Processo(latch));
        }

        try {
            latch.await(1, TimeUnit.DAYS);
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.print("complted");
    }
}

class Processo implements Runnable {

    public CountDownLatch latch;

    public Processo(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("started"+ Thread.currentThread().getId());
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        latch.countDown();

    }

}
