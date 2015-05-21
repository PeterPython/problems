// Write a code that returns the deepest node in a binary tree.

import java.util.*;

public class BST {
	private Node root;

	public class Node {
		int item;
		Node left;
		Node right;

		Node(int item) {
			this.item = item;
		}
	}

	public int get(int item) {
		return get(root, item);
	}

	private int get(Node node, int item) {
		if(node == null) {
			return -1;
		}

		if(item < node.item) {
			return get(node.left, item);
		}
		else if(item > node.item) {
			return get(node.right, item);
		}
		else {
			return node.item;
		}
	}

	public void put(int item) {
		root = put(root, item);
	}

	private Node put(Node node, int item) {
		if(node == null) {
			return new Node(item);
		}

		if(item < node.item) {
			node.left = put(node.left, item);
		}
		else if(item > node.item) {
			node.right = put(node.right, item);
		}
		else {
			node.item = item;
		}
		return node;
	}


	public int getDeepestNode() {
		HashMap<Integer, Node> map = new HashMap<Integer, Node>();
		int index = getDeepestNode(root, 0, map);
		Node i = map.get(index);
		return i.item;
	}


	// This will return the deepest node (if there are many then return the right node)
	// To return the left one, just switch the order of traversal
	private int getDeepestNode(Node node, int count, HashMap<Integer, Node> map) {
		// Base case when there is no children
		if(node.left == null && node.right == null) {
			map.put(count, node);
			return count;
		}

		int left = 0;
		int right = 0;

		if(node.left != null) {
			left = getDeepestNode(node.left, count+1, map);
		}

		if(node.right != null) {
			right = getDeepestNode(node.right, count+1, map);
		}

		return Math.max(left, right);
	}


	public static void main(String args[]) {
		BST bst = new BST();
		bst.put(5);
		bst.put(3);
		bst.put(2);
		bst.put(1);
		bst.put(4);
		bst.put(10);
		bst.put(7);
		bst.put(8);
		bst.put(9);  // Deepest
		bst.put(10);

		int deepest = bst.getDeepestNode();

		System.out.print(deepest);
		System.out.println();
	}
}