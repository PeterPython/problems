// Problem 9.9:  Given a binary tree, write a function which 
// forms a linked list from the leaves of the binary tree. 
// The leaves should appear in left-to-right order. For example, 
// when applied to the binary tree in Figure 9.1 on Page 73, your
// function should return (D,E,H,M,N,P).
// Page 78. Solution 243

import java.util.LinkedList;

public class BST {
	private Node root;

	private class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
		}
	}

	public void add(int key) {
		root = add(root, key);
	}

	private Node add(Node node, int key) {
		if(node == null) {
			return new Node(key);
		}
		if(key < node.key) {
			node.left = add(node.left, key);
		}
		else if(key > node.key) {
			node.right = add(node.right, key);
		}
		else {
			node.key = key;
		}
		return node;
	}


	public LinkedList<Integer> leavesToList() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		leavesToList(root, list);
		return list;
	}

	private void leavesToList(Node node, LinkedList<Integer> list) {
		if(node.left == null && node.right == null) {
			list.add(node.key);
		}
		if(node.left != null) {
			leavesToList(node.left, list);
		}
		if(node.right != null) {
			leavesToList(node.right, list);
		}
	}


	// Main
	public static void main(String args[]) {
		BST bst = new BST();
		bst.add(8);
		bst.add(5);
		bst.add(3);
		bst.add(2);  // Leaf
		bst.add(6);  // Leaf
		bst.add(4);  // Leaf
		bst.add(14);
		bst.add(11);  // Leaf

		LinkedList<Integer> list = bst.leavesToList();
		for(Integer i : list) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}