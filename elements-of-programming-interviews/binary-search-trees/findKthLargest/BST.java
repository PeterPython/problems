// Problem 14.11: Given the root of a BST and an integer 
// k, design afunction that finds the k largest elements in 
// this BST. For example, if the input to your function is the BST
// Page 108. Solution 317

public class BST {
	private Node root;

	private class Node {
		int item;
		Node left;
		Node right;

		public Node(int item) {
			this.item = item;
		}
	}

	public void add(int item) {
		root = add(root, item);
	}

	private Node add(Node node, int item) {
		if(node == null) {
			return new Node(item);
		}
		if(item < node.item) {
			node.left = add(node.left, item);
		}
		else if(item > node.item) {
			node.right = add(node.right, item);
		}
		else {
			node.item = item;
		}
		return node;
	}

	int index = 0;

	public void findKthGreatest(int k) {
		findKthGreatest(root, k);
	}

	public void findKthGreatest(Node node, int k) {
		if(node.right != null) {
			findKthGreatest(node.right, k);
		}

		index++;
		if(index == k) {
			System.out.println(node.item);
			return;
		}

		if(node.left != null) {
			findKthGreatest(node.left, k);
		}
	}


	public static void main(String args[]) {
		BST bst = new BST();
		bst.add(5);
		bst.add(3);
		bst.add(2);
		bst.add(7);
		bst.add(6);
		bst.add(9);

		bst.findKthGreatest(3);
	}
}