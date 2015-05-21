// Problem 4.4: Given a binary tree, design an algorithm which creates 
// a linked list of all the nodes at each depth (e.g., if you have 
// a tree with depth D, you'll have D linked lists).
// Page 86. Solution 224

import java.util.*;

public class BST<Key extends Comparable<Key>> {
	private Node root;

	public class Node {
		Key key;
		Node left;
		Node right;

		Node(Key key) {
			this.key = key;
		}
	}

	public void put(Key key) {
		root = put(root, key);
	}

	public Node put(Node node, Key key) {
		if(node == null) {
			return new Node(key);
		}
		if(key.compareTo(node.key) < 0) {
			node.left = put(node.left, key);
		}
		else if(key.compareTo(node.key) > 0) {
			node.right = put(node.right, key);
		}
		else {
			node.key = key;
		}

		return node;
	}

	private void createLevelLinkedList(Node node, 
		ArrayList<LinkedList<Key>> arrayList, int level) {
		LinkedList<Key> list = null;
		if(node == null) {
			return;
		}
		if(arrayList.size() == level) {
			list = new LinkedList<Key>();
			arrayList.add(list);
		}
		else {
			list = arrayList.get(level);
		}
		list.add(node.key);

		createLevelLinkedList(node.left, arrayList, level+1);
		createLevelLinkedList(node.right, arrayList, level+1);
	}

	public ArrayList<LinkedList<Key>> createLevelLinkedList() {
		ArrayList<LinkedList<Key>> arrayList = new ArrayList<LinkedList<Key>>();
		createLevelLinkedList(root, arrayList, 0);
		return arrayList;
	}
}