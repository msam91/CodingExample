package amplitude;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PCUsingLock {

	public static void main(String args[]) {
		PCUsingLockApp a = new PCUsingLockApp();
		a.main();
	}

}

class PCUsingLockProducer implements Runnable {

	LinkedList<Integer> list;
	int limit;
	Object lock;

	public PCUsingLockProducer(LinkedList<Integer> list, int limit, Object lock) {
		this.list = list;
		this.limit = limit;
		this.lock = lock;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int value = 0;

		while (true) {
			synchronized (lock) {
				while (list.size() == limit) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				list.add(value++);
				lock.notify();
			}
		}

	}
}

class PCUsingLockConsumer implements Runnable {

	LinkedList<Integer> list;
	Object lock;

	public PCUsingLockConsumer(LinkedList<Integer> list, Object lock) {
		this.list = list;
		this.lock = lock;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (true) {
			synchronized (lock) {
				while (list.size() == 0) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("list size is :" + list.size());
				int n = list.removeFirst();
				System.out.println("Removed :" + n);
				lock.notify();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

}

class PCUsingLockApp {
	public void main() {

		LinkedList<Integer> list = new LinkedList<>();
		Object lock = new Object();

		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 5; i++) {
			executorService.submit(new PCUsingLockProducer(list, 10, lock));
		}

		for (int i = 0; i < 5; i++) {
			executorService.submit(new PCUsingLockConsumer(list, lock));
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
