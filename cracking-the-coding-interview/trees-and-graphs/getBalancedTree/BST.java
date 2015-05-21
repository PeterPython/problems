// Problem 4.3: Given a sorted (increasing order) array with
// unique integer elements, write an algoithm to create 
// a binary search tree with minimal height.
// Page 86. Solution 222.

public class BST {
	private Node root;

	private class Node {
		int key;
		Node left;
		Node right;

		Node(int key) {
			this.key = key;
		}
	}

	public int get(int key) {
		return get(root, key);
	}

	private int get(Node node, int key) {
		if(node == null) {
			return -1;
		}
		if(key < node.key) {
			return get(node.left, key);
		}
		else if(key > node.key) {
			return get(node.right, key);
		}
		else {
			return node.key;
		}
	}

	public void put(int key) {
		root = put(root, key);
	}

	private Node put(Node node, int key) {
		if(node == null) {
			return new Node(key);
		}
		if(key < node.key) {
			node.left = put(node.left, key);
		}
		else if(key > node.key) {
			node.right = put(node.right, key);
		}
		else {
			node.key = key;
		}
		return node;
	}


	// Take a sorted array an insert into the Tree to make it balanced
	public void getBalanced(int sorted[]) {
		getBalanced(sorted, 0, sorted.length);
	}

	public void getBalanced(int sorted[], int lo, int hi) {
		if(hi <= lo) {
			return;
		}

		int mid = lo + (hi-lo)/2;

		// System.out.print(sorted[mid] + " ");
		put(sorted[mid]);

		getBalanced(sorted, lo, mid);
		getBalanced(sorted, mid+1, hi);
	}


	public void traverse() {
		traverse(root);
	}

	private void traverse(Node node) {
		if(node.left != null) {
			traverse(node.left);
		}
		System.out.print(node.key + " ");
		if(node.right != null) {
			traverse(node.right);
		}
	}
}