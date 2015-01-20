// Problem 4.1: Implement a function to check if a binary 
// tree is balanced. For the purposes of this question, a 
// balanced tree is defined to be a tree such that the heights 
// of the two subtrees of any node never differ by more than one.
// Page 86. Solution 220

public class BST<Key extends Comparable<Key>, Value> {
	private Node root;

	private class Node {
		Key key;
		Value val;
		Node left;
		Node right;

		Node(Key key, Value val) {
			this.key = key;
			this.val = val;
		}
	}

	public Value get(Key key) {
		return get(root, key);
	}

	private Value get(Node node, Key key) {
		if(node == null) {
			return null;
		}
		if(key.compareTo(node.key) < 0) {
			return get(node.left, key);
		}
		else if(key.compareTo(node.key) > 0) {
			return get(node.right, key);
		}
		else {
			return node.val;
		}
	}

	public void put(Key key, Value val) {
		root = put(root, key, val);
	}

	private Node put(Node node, Key key, Value val) {
		if(node == null) {
			return new Node(key, val);
		}
		if(key.compareTo(node.key) < 0) {
			node.left = put(node.left, key, val);
		}
		else if(key.compareTo(node.key) > 0) {
			node.right = put(node.right, key, val);
		}
		else {
			node.val = val;
		}
		return node;
	}


	// Check if tree is balanced
	public boolean isBalanced() {
		return checkHeight(root) != -1;
	}


	// If tree does not have same height for left and right sides return -1
	public int checkHeight(Node node) {
		if(node == null) {
			return 0;
		}

		int leftHeight = checkHeight(node.left);
		if(leftHeight == -1) {
			return -1;
		}

		int rightHeight = checkHeight(node.right);
		if(rightHeight == -1) {
			return -1;
		}

		int diffHeight = Math.abs(leftHeight - rightHeight);
		if(diffHeight > 1) {
			return -1;
		}
		else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
}