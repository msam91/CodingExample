package amplitude;

import java.util.concurrent.Semaphore;

public class Connection {

	private static Connection instance = null;
	private static int connections = 0;
	private Semaphore sem = new Semaphore(10, true);

	private Connection() {

	}

	public static Connection getInstance() {
		if (instance == null) {
			instance = new Connection();
		}
		return instance;
	}

	private void doConnect() {
		synchronized (this) {
			connections++;
			System.out.println("acquired connection" + connections);
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		synchronized (this) {
			connections--;
			System.out.println("released connection" + connections);

		}
	}

	public void connect() {
		try {
			sem.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			doConnect();
		} catch (Exception e) {

		} finally {
			sem.release();
		}

	}

}
