// Problem 9.10: Write a function that prints the nodes on the exterior
// of a binary tree in anti-clockwise order

public class BST {
	private Node root;

	private class Node {
		int item;
		Node left;
		Node right;

		Node(int item) {
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

	public void printTreeExterior() {
		printTreeExterior(root);
		printRightSide(root);
	}

	private boolean stop = false;  // Flag it when to stop printing the right side of tree
	
	private void printTreeExterior(Node node) {
		// This will print the left side of the Tree in pre order
		if(!stop && (node.left != null || node.right != null)) {
			System.out.println(node.item);
		}

		if(node.left == null && node.right == null) {  // When reach the end of left branch flag it
			stop = true;
		}

		if(node.left != null) {
			printTreeExterior(node.left);
		}

		if(node.right != null) {
			printTreeExterior(node.right);
		}

		// This will print the leaf of the tree
		if(stop && node.left == null && node.right == null) {
			System.out.println(node.item);
		}
	}

	private void printRightSide(Node node) {
		if(node.right != null) {
			printRightSide(node.right);
		}
		// Print the right side of tree except for last and first nodes
		if((node.left == null && node.right == null) || node == root) {
			return;
		} 
		System.out.println(node.item);
	}


	// Main
	public static void main(String args[]) {
		BST bst = new BST();
		bst.add(6);
		bst.add(4);
		bst.add(5);
		bst.add(1);
		bst.add(2);
		bst.add(3);
		bst.add(9);
		bst.add(8);
		bst.add(7);
		bst.add(10);
		bst.add(11);

		bst.printTreeExterior();
	}
}