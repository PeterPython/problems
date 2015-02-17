// Re-creating A Binary Search Tree Given Its Pre-order Traversal
// http://www.fusu.us/2013/07/re-creating-binary-search-tree-given.html

public class BST {
	private int index;

	public static Node preOrderToTree(int a[]) {
		int length = a.length;
		index = 0;

		return preOrderToTree(a, length, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static Node preOrderToTree(int a[], int length, int min, int max) {
		if(index >= length) {
			return null;
		}

		Node node = null;
		int currentNode = a[index];

		if(a[index] > min && a[index] < max) {
			node = new Node(currentNode);
			index++;

			if(index < length) {
				node.left = preOrderToTree(a, length, min, currentNode);
			}

			if(index < length) {
				node.right = preOrderToTree(a, length, currentNode, max);
			}
		}

		return node;
	}
}