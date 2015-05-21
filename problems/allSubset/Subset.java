// Problem to find all the subsets of an array

public class Subset {
	public static void getSubset(int a[]) {
		for(int i=0; i<a.length; i++) {
			getSubset(a, i, "");
		}
	}

	public static void getSubset(int a[], int index, String str) {
		if(index == a.length) {
			return;
		}

		str += " " + a[index];
		System.out.println(str);

		getSubset(a, index+1, str);
	}


	// Main
	public static void main(String args[]) {
		int a[] = {1,2,3,4,5,6};
		getSubset(a);
	}
}