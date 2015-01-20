// Demo for Problem 4.1

public class Demo {
	public static void main(String args[]) {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();

		bst.put(4, 4);

		bst.put(2, 2);
		bst.put(1, 1);
		bst.put(3, 3);

		bst.put(6, 6);
		bst.put(5, 5);
		bst.put(7, 7);

		System.out.println(bst.isBalanced());
	}
}