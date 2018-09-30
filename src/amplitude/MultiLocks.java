package amplitude;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MultiLocks {

	public List<Integer> list1 = new ArrayList<>();
	public List<Integer> list2 = new ArrayList<>();

	Object lock1 = new Object();
	Object lock2 = new Object();

	Random r = new Random();

	public static void main(String args[]) {
		MultiLocks m = new MultiLocks();

		long start = System.currentTimeMillis();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				m.process();
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				m.process();
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();

		System.out.println("total time taken:" + (end - start));
		System.out.println("list1 size:" + m.list1.size());
		System.out.println("list2 size:" + m.list2.size());

	}

	private void process() {

		for (int i = 0; i < 1000; i++) {
			addToList1();
			addToList2();
		}
	}

	private void addToList1() {

		synchronized (lock1) {

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list1.add(r.nextInt(100));
		}
	}

	private void addToList2() {
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list2.add(r.nextInt(100));
		}
	}
}
