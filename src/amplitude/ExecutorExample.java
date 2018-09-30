package amplitude;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorExample {

	public static void main(String args[]) {
		App a = new App();
		a.main();
	}

}

class Processor implements Runnable {

	int id;

	public Processor(int id) {
		this.id = id;
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

	}

}

class App {
	public void main() {

		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 1000; i++) {
			executorService.submit(new Processor(i));
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
