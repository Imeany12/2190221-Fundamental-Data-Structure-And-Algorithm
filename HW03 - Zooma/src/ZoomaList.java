public class ZoomaList extends CDLinkedList {
	int score = 0;

	public ZoomaList() {
		super();
	}

	public ZoomaList(CDLinkedList l) {
		header = l.header;
		size = l.size;
	}

	public void insert(int value, Iterator p) throws Exception {
		// fill code

		if (p == null || !(p instanceof DListIterator)) {
			return;
		} else if (size == 0 || size == 1) {
			super.insert(value, p);
		} else {
			super.insert(value, p);
			if (((DListIterator) p).currentNode != header) {
				DListIterator l = (DListIterator) p;
				l.next();
//				itr l is still p meaning that the p has been move the the node next to header
				DListIterator r = new DListIterator(((DListIterator) p).currentNode);
				while (l.currentNode.data == r.currentNode.data) {

//					set the itrs to the same position
					if (l.currentNode.data == header.data) {
						l.currentNode = r.currentNode;
					} else {
						r.currentNode = l.currentNode;
					}
					int repeatedTime = -1;
					while (l.currentNode.data == value) {
						l.currentNode = l.currentNode.previousNode;
						repeatedTime++;
					}
					while (r.currentNode.data == value) {
						r.currentNode = r.currentNode.nextNode;
						repeatedTime++;
					}
					if (repeatedTime >= 3) {
						this.removeBetween(l, r, repeatedTime);
						score += repeatedTime;
//						value can be set to l's node data since if it will collide it should be the same
						value = l.currentNode.data;
					} else {
						break;
					}

				}
			}

		}
	}

	public void removeBetween(DListIterator left, DListIterator right, int inc) {
		// fill code
		if (left.currentNode == right.currentNode) {
			return;
		}
		left.currentNode.nextNode = right.currentNode;
		right.currentNode.previousNode = left.currentNode;
		size -= inc;

	}

}
