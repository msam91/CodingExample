package amplitude;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PCUsingBQ {
	public static void main(String args[]) {
		PCUsingBQApp a = new PCUsingBQApp();
		a.main();
	}

}

class PCUsingBQProducer implements Runnable {

	ArrayBlockingQueue<Integer> q;

	public PCUsingBQProducer(ArrayBlockingQueue<Integer> q) {
		this.q = q;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Random r = new Random();

		while (true) {
			try {
				q.put(r.nextInt(1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("number added " + " queue size " + q.size());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}

class PCUsingBQConsumer implements Runnable {

	ArrayBlockingQueue<Integer> q;

	public PCUsingBQConsumer(ArrayBlockingQueue<Integer> q) {
		this.q = q;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Random r = new Random();
		while (true) {
			try {
				if (true) {
					int n = q.take();
					System.out.println(n + " taken out " + " queue size " + q.size());
				}

			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

class PCUsingBQApp {
	public void main() {

		ArrayBlockingQueue<Integer> q = new ArrayBlockingQueue<>(1000);

		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 4; i++) {
			executorService.submit(new PCUsingBQProducer(q));
		}

		for (int i = 0; i < 10; i++) {
			executorService.submit(new PCUsingBQConsumer(q));
		}

		executorService.shutdown();

		try {
			executorService.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
