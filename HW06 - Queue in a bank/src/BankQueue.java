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
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (DeQ counter : counters) {
			if (special.size() == neededQueue) {
				break;
			} else {
				while (counter.size() > neededQueue) {
					temp.add(counter.removeLast());
				}
				while (special.size() < neededQueue && !temp.isEmpty()) {
					special.insertLast(temp.get(temp.size() - 1));
					temp.remove(temp.size() - 1);
				}
				while (temp.size() > 0) {
					counter.insertLast(temp.get(temp.size()-1));
					temp.remove(temp.size() - 1);
				}
				
			}
		}
		if (special.size() == 0) {
			special.insertLast((counters[counters.length-1].removeLast()));
		}

		return;
	}

}
