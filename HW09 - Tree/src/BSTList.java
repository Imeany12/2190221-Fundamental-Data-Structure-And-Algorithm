import java.util.ArrayList;

public class BSTList {
	BSTNodeList root;
	int size;

	public BSTList() {
		root = null;
		size = 0;
	}

	public BSTList(BSTNodeList root, int size) {
		this.root = root;
		this.size = size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void makeEmpty() {
		root = null;
		size = 0;
	}

	public BSTNodeList find(Comparable v) {
		BSTNodeList temp = root;
		while (temp != null && temp.dataList.get(0).first != ((Pairdata) v).first) {
			if (((Pairdata) v).first - temp.dataList.get(0).first < 0) {
				temp = temp.left;
			} else {
				temp = temp.right;
			}
		}
		if (temp == null) // not found
			return null;
		else if (temp != null && temp.dataList.get(0).first == ((Pairdata) v).first) {
			if (!temp.dataList.contains(v)) {
				return null;
			}
		}
		return temp;
	}

	public BSTNodeList insert(Comparable v) {
		BSTNodeList parent = null;
		BSTNodeList temp = root;
		while (temp != null && temp.dataList.get(0).first != ((Pairdata) v).first) {
			if (((Pairdata) v).first - temp.dataList.get(0).first < 0) {
				parent = temp;
				temp = temp.left;
			} else {
				parent = temp;
				temp = temp.right;
			}
		}

		// The 1st value of v is not stored anywhere
		if (temp == null) {
			BSTNodeList n = new BSTNodeList(new ArrayList<Pairdata>(), temp, temp, parent);
			n.dataList.add((Pairdata) v);
			if (parent == null) {
				root = n;
			} else if (((Pairdata) v).first - parent.dataList.get(0).first < 0) {
				parent.left = n;
			} else {
				parent.right = n;
			}
			size++;
			return n;
		} else {
			if (!temp.dataList.contains(v)) {
				temp.dataList.add((Pairdata) v);
				
				// This bad boy (this.size) is the number of Pairdata in every node not number of Node 
				size++;
			}
			return temp;

		}

	}

	public BSTNodeList findMin(BSTNodeList n) {
		BSTNodeList temp = n;
		if (temp == null)
			return null;
		while (temp.left != null) {
			temp = temp.left;
		}
		return temp;
	}

}
