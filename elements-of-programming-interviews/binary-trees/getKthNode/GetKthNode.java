// Problem 9.6: Design afunction that efficiently computes 
// the k-th node appearing in an inorder traversal. Specijiallly, 
// your function should take as input a binary tree T and an 
// integer k: Each node hils a size field, which is the number of
// nodes in the subtree rooted at tha: node. What is the time 
// complexity of your function?
// Page 76. Solution 240


//  If the left child has k - 1 children, then the root 
// is the k-th node; if the left child has k or more children, 
// then the k-th node is the k-th node of the left subtree;
// and if the left child has l < k -1 children, the k-th 
// node is the k - (1+ l)-th node of the right subtree.

public class GetKthNode {
	public Node getKthNode(Node node, int k) {
		if(size(node.left)+1 < k) {
			return getKthNode(node.right, k-size(node.left)-1);
		}
		else if(size(node.left)+1 == k) {
			return node;
		}
		else {  // left_size > k-1
			return getKthNode(node.left, k);
		}
	}
}