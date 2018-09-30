package amplitude;

import java.util.concurrent.atomic.AtomicInteger;

public class Synchronization {
	
	AtomicInteger count =new AtomicInteger(0);

	public static void main(String args[]) {
		Synchronization s = new Synchronization();
		s.process();
	}
	
	public  void increment() {
		count.incrementAndGet();
	}
	
	public void process() {
		
		Thread t1  = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<10000;i++) {
					increment();
				}
				
			}
		});
		
		Thread t2  = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<10000;i++) {
					increment();
				}
				
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(count);
		
	}
	
}
