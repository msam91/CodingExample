package amplitude;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FutureAndCallable {

	public static void main(String args[]) {
		
	 ExecutorService exec = Executors.newCachedThreadPool();
	 
	 
	Future<?>fu = exec.submit(new Callable<Void>() {

		@Override
		public Void call() throws Exception {
			// TODO Auto-generated method stub
			for(int i=0;i<1E8;i++) {
				if(Thread.currentThread().isInterrupted()) {
				System.out.println("interrupted");
				break;
				}
			}
			return null;
		}
	});
	
	exec.shutdown();
	
	try {
		Thread.sleep(1);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	fu.cancel(true);

	try {
		exec.awaitTermination(1, TimeUnit.DAYS);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
}
