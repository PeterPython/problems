// Problem 2.1: Write code to remove duplicates from an unsorted linked list. Page 184

public class RemoveDuplicates {
	public static void main(String args[]) {
		SequentialList<Integer> list = new SequentialList<Integer>();

		for(Integer i=1; i<10; i++) {
			list.add(i);
		}

		for(Integer i=1; i<10; i++) {
			list.add(i);
		}

		System.out.println("Original List: ");
		for(Integer j : list) {
			System.out.print(j + " ");
		}
		System.out.println();

		list.removeDuplicates();
		System.out.println("Removed Duplicates List: ");
		for(Integer j : list) {
			System.out.print(j + " ");
		}
		System.out.println();


		System.out.println("\nRemove Node: ");
		SequentialList<Integer> list2 = new SequentialList<Integer>();

		for(Integer i=1; i<10; i++) {
			list2.add(i);
		}

		list2.removeNode(3);
		list2.removeNode(1);
		list2.removeNode(2);
		list2.removeNode(9);

		for(Integer j : list2) {
			System.out.print(j + " ");
		}
		System.out.println();
	}
}