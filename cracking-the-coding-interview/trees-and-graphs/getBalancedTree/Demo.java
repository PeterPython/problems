public class Demo {
	public static void main(String args[]) {
		BST bst = new BST();

		int array[] = {1,2,3,4,5,6,7};

		bst.getBalanced(array);

		bst.traverse();
		System.out.println();
	}
}