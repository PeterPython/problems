// Problem 4.5: Implement a function to check if a binary tree is a binary search tree.
// Page 86. Solution 229

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

	public void put(int key) {
		root = put(root, key);
	}

	public Node put(Node node, int key) {
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

	public void traverse() {
		traverse(root);
	}

	private void traverse(Node node) {
		if(node.left != null) {
			traverse(node.left);
		}
		if(node.right != null) {
			traverse(node.right);
		}
	}

	public boolean isBST() {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}


	// Check if Binary Tree is a BST
	private boolean isBST(Node node, int min, int max) {
		if(node == null) {
			return true;
		}

		if(node.key <= min || node.key > max) {
			return false;
		}

		if(!isBST(node.left, min, node.key) || !isBST(node.right, node.key, max)) {
			return false;
		}

		return true;
	} 
}