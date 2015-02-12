// Problem 9.1: Write a function that takes as input the root of 
// a binary tree and returns true or false depending on whether 
// the tree is balanced. Use O(h) additional storage, where h is 
// the height of the tree.
// Page 75. Solution 235

public class BST {
	private Node root;

	private class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
		}
	}

	public void put(int key) {
		root = put(root, key);
	}

	private Node put(Node node, int key) {
		if(node == null) {
			return new Node(key);
		}
		else if(key < node.key) {
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

	public boolean isBalanced() {
		int balanced = isBalanced(root, 0);
		if(balanced == -1) {
			return false;
		}
		else {
			return true;
		}
	}

	public int isBalanced(Node node, int level) {
		if(node == null) {
			return level;
		}

		int left = isBalanced(node.left, level+1);
		if(left == -1) {
			return -1;
		}

		int right = isBalanced(node.right, level+1);
		if(right == -1) {
			return -1;
		}

		if(Math.abs(left-right) > 1) {
			return -1;
		}
		else {
			return Math.abs(left-right);
		}
	}


	// Demo
	public static void main(String args[]) {
		BST bst = new BST();
		bst.put(7);
		bst.put(5);
		bst.put(4);

		System.out.println(bst.isBalanced());
	}
}