package amplitude;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SemaphoreApp {

	public static void main(String args[]) {
		Connection conn = Connection.getInstance();
		ExecutorService executorService = Executors.newCachedThreadPool();

		for (int i = 0; i < 200; i++) {
			executorService.submit(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					conn.connect();

				}

			});

		}
		
		
	}
}
