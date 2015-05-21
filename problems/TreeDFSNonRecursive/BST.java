// Depth First Search of a Binary Search Tree without Recursion
// http://stackoverflow.com/questions/5278580/non-recursive-depth-first-search-algorithm

import java.util.Stack;

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
		else if(key.compareTo(node.key) < 0) {
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
		else if(key.compareTo(node.key) < 0) {
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


	// Non recursive DFS. This is only pre-order traversal
	public void dfs() {
		Stack<Node> st = new Stack<Node>();
		st.push(root);

		while(!st.isEmpty()) {
			Node current = st.pop();
			System.out.print(current.key + " ");

			if(current.right != null) {
				st.push(current.right);
			}
			// System.out.print(current.key + " ");
			if(current.left != null) {
				st.push(current.left);
			}
			// System.out.print(current.key + " ");
		}
	}
}