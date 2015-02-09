// Problem 4.7: Design an algorithm and write code to find the 
// first common ancestor of two nodes in a binary tree. Avoid 
// storing additional nodes in a data structure. 
// NOTE: This is not necessarily a binary search tree.
// Page 86. Solution 230

public class BST<Key extends Comparable<Key>> {
	private Node root;

	private class Node {
		Key key;
		Node left;
		Node right;

		Node(Key key) {
			this.key = key;
		}
	}

	public void add(Key key) {
		root = add(root, key);
	}

	private Node add(Node node, Key key) {
		if(node == null) {
			return new Node(key);
		}

		if(key.compareTo(node.key) < 0) {
			node.left = add(node.left, key);
		}
		else if(key.compareTo(node.key) > 0) {
			node.right = add(node.right, key);
		}
		else {
			node.key = key;
		}
		return node;
	}

	// Find Common Ancestor
	public Key findCommonAncestor(Key p, Key q) {
		Node common = findCommonAncestor(root, p, q);
		return common.key;
	}

	public Node findCommonAncestor(Node node, Key p, Key q) {
		if(node == null) {
			return null;
		}

		if(node.key == p && node.key == q) {
			return node;
		}

		Node x = findCommonAncestor(node.left, p, q);
		if(x != null && x.key != p && x.key != q) {
			return x;    // Found ancestor already
		}

		Node y = findCommonAncestor(node.right, p, q);
		if(y != null && y.key != p && y.key != q) {
			return y;    // Found ancestor already
		}

		if(x != null && y != null) {
			return node;
		}
		else if(node == p || node == q) {
			return node;
		}
		else {
			Node nodeSide = x == null ? y : x;
			return nodeSide;
		}
	}


	public static void main(String args[]) {
		BST<Integer> bst = new BST<Integer>();
		bst.add(7);
		bst.add(4);
		bst.add(5);
		bst.add(3);
		bst.add(2);
		bst.add(6);

		System.out.println(bst.findCommonAncestor(2, 6));
	}
}