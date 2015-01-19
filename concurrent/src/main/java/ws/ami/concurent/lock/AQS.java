package ws.ami.concurent.lock;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class AQS {
	Syn syn = new Syn();

	public void lock() {
		syn.acquire(1);

	}

	public class Syn extends AbstractQueuedSynchronizer {

	}
	


}
