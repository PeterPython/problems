// Problem 14.5: Write a function that takes a BST T and a key k,
// and returns the first entry larger than k that would appear in 
// an inorder walk. If k is absent or no key larger than k is present, 
// return null. For example, when applied to the BST in Figure 14.1 
// on the preceding page you should return 29 if k = 23; if k = 32, 
// you should return null.
// Page 106. Solution 312.

public class BST {
	private Node root;

	private class Node {
		int item;
		Node left, right;

		Node(int item) {
			this.item = item;
		}
	}

	public void add(int item) {
		root = add(root, item);
	}

	public Node add(Node node, int item) {
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

	public int findNext(int k) {
		return findNext(root, k);
	}

	public int findNext(Node node, int k) {
		Node first = null;
		Node current = node;
		boolean found = false;

		while(current != null) {
			if(k == current.item) {
				found = true;
				current = current.right;
			}
			else if(k < current.item) {
				first = current;  // Keep track of previous node
				current = current.left;
			}
			else {  // k > current.item
				current = current.right;
			}
		}

		return found ? first.item : -1;
	}

	public void traverse() {
		traverse(root);
	}

	public void traverse(Node node) {
		if(node.left != null) {
			traverse(node.left);
		}

		System.out.print(node.item + " ");

		if(node.right != null) {
			traverse(node.right);
		}
	}

	// Main
	public static void main(String args[]) {
		BST bst = new BST();
		bst.add(7);
		bst.add(4);
		bst.add(2);
		bst.add(1);
		bst.add(6);
		bst.add(3);
		bst.add(9);
		bst.add(8);
		bst.add(6);
		bst.add(13);
		bst.add(11);

		bst.traverse();
		System.out.println();

		System.out.println(bst.findNext(9));
	}
}