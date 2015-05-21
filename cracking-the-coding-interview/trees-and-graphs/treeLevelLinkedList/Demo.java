// Demo for Problem 4.4: Given a binary tree, design an algorithm which creates 
// a linked list of all the nodes at each depth (e.g., if you have 
// a tree with depth D, you'll have D linked lists).
// Page 86. Solution 224

import java.util.*;

public class Demo {
	public static void main(String args[]) {
		BST<Integer> bst = new BST<Integer>();

		bst.put(5);
		bst.put(3);
		bst.put(1);
		bst.put(2);
		bst.put(4);
		bst.put(7);
		bst.put(9);
		bst.put(8);
		bst.put(6);

		ArrayList<LinkedList<Integer>> list = new ArrayList<LinkedList<Integer>>();

		list = bst.createLevelLinkedList();
		System.out.println(list.size() + " ");
	}
}