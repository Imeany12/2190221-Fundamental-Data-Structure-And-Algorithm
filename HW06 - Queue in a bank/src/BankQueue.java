import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class BankQueue { // must work for any implementation of DeQ
	DeQ[] counters;
	DeQ special;

	public BankQueue(DeQ[] counters, DeQ special) {
		super();
		this.counters = counters;
		this.special = special;
	}

	// Write this method
	public void distribute() throws Exception {
		double numberOfPeople = 0;
		for (DeQ counter : counters) {
			numberOfPeople += counter.size();
		}
		numberOfPeople += special.size();
		double numberOfQueue = counters.length + 1;
		double neededQueue = Math.round(numberOfPeople / numberOfQueue);
		for (DeQ counter : counters) {
			if (special.size() == neededQueue) {
				break;
			} else {
				// Rotate until the queue that exceed neededQueue
				for (int i = 0; i < neededQueue; i++) {
					counter.insertLast(counter.removeFirst());
				}
				
				// Move the exceeded queue to special queue
				while (special.size() < neededQueue && counter.size() > neededQueue) {
					special.insertLast(counter.removeFirst());
				}
				
				// If the special queue is full shift the queue in counter back
				if (counter.size() > neededQueue) {
					for (int i = 0; i < counter.size() - neededQueue; i++) {
						counter.insertLast(counter.removeFirst());
					}
				}
			}
		}
		if (special.size() == 0) {
			special.insertLast((counters[counters.length-1].removeLast()));
		}

		return;
	}

}
