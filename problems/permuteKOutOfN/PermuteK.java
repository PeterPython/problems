// Permutation of k characters out of n of Strings 

public class PermuteK {
	public static void permuteKOutOfN(String str, int k) {
		int n = str.length();
		permuteKOutOfN("", str, n-k);
	}

	public static void permuteKOutOfN(String perm, String str, int k) {
		int n = str.length();
		if(n == k) {
			System.out.println(perm);
			return;
		}

		for(int i=0; i<n; i++) {
			permuteKOutOfN(perm + str.charAt(i), str.substring(0,i) + str.substring(i+1), k);
		}
	}


	public static void main(String args[]) {
		System.out.println("1");
		permuteKOutOfN("abc", 1);

		System.out.println("\n2");	
		permuteKOutOfN("abc", 2);

		System.out.println("\n3");
		permuteKOutOfN("abc", 3);	
	}
}