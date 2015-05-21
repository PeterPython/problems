public class Demo {
	public static void main(String args[]) {
		System.out.println("Traversal Demo");
		BST<Integer, String> bst2 = new BST<Integer, String>();

		System.out.println("bst2.put(6, '6')"); bst2.put(6, "6");
		System.out.println("bst2.put(2, '2');"); bst2.put(2, "2");
		System.out.println("bst2.put(1, '1');"); bst2.put(1, "1");
		System.out.println("bst2.put(4, '4');"); bst2.put(4, "4");
		System.out.println("bst2.put(3, '3');"); bst2.put(3, "3");
		System.out.println("bst2.put(5, '5');"); bst2.put(5, "5");
		System.out.println("bst2.put(7, '7');"); bst2.put(7, "7");
		System.out.println("bst2.put(9, '9');"); bst2.put(9, "9");
		System.out.println("bst2.put(8, '8');"); bst2.put(8, "8");

		bst2.dfs();
		System.out.println();
	}
}