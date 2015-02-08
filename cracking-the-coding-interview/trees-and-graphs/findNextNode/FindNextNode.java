// Problem 4.6: Write an algorithm to find the 'next'node 
// (i.e., in-order successor) of a given node in a binary search 
// tree. You may assume that each node has a link to its parent.
// Page 86. Solution 229

public class FindNextNode {
	public static Node findNextNode(Node node) {
		if(node == null) {
			return null;
		}

		if(node.right != null) {
			return getMin(node.right);
		}
		else {
			while(node.parent != null && node.parent.right == node) {
				node = node.parent; // Go up until we're on left instead of right
			}
			return node.parent;
		}
		return null;
	}

	// Get left most child or min of a tree
	public static Node getMin(Node node) {
		if(node == null) {
			return null;
		}
		if(node.left == null) {
			return node;
		}
		return getMin(node.left);
	}
}