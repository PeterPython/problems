// Demo for Problem 4.5: Implement a function to check if a binary tree is a binary search tree.
// Page 86. Solution 229

public class Demo {
	public static void main(String args[]) {
		BST bst = new BST();

		bst.put(5);
		bst.put(3);
		bst.put(1);
		bst.put(2);
		bst.put(4);
		bst.put(7);
		bst.put(9);
		bst.put(8);
		bst.put(6);

		System.out.println(bst.isBST());
	}
}