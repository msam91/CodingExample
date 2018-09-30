package amplitude;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownExample {
	public static void main(String args[]) {
		CountDownApp a = new CountDownApp();
		a.main();
	}

}

class CountDownProcessor implements Runnable {

	int id;
	CountDownLatch latch;

	public CountDownProcessor(int id, CountDownLatch latch) {
		this.id = id;
		this.latch = latch;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("task started.." + id);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("task completed.." + id);
		latch.countDown();

	}

}

class CountDownApp {
	public void main() {
		CountDownLatch latch = new CountDownLatch(3);
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for (int i = 0; i <100; i++) {
			executorService.submit(new CountDownProcessor(i, latch));
		}

		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("MAIN COMPLETED");

	}

}
