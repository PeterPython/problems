// Given n, how many structurally unique BST’s (binary search trees) that store values 1…n?
// http://www.lifeincode.net/programming/leetcode-unique-binary-search-trees-i-and-ii-java/

public class UniqueBST {
	public static int uniqueBST(int n) {
		int a[] = new int[n+1];
		a[0] = 1;

		for(int i=1; i<=n; i++) {
			for(int j=0; j<i; j++) {
				a[i] += a[j] * a[i-j-1];
			}
		}
		return a[n];
	}

	public static void main(String args[]) {
		System.out.println(uniqueBST(1));  // 1
		System.out.println(uniqueBST(2));  // 2
		System.out.println(uniqueBST(3));  // 5
		System.out.println(uniqueBST(4));  // 14
	}
}