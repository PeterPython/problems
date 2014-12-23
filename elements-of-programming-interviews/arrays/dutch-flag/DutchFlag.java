// Problem 6.1: Write a function that takes an array A and an index 
// rearranges the elements such that all elements less than A[i] appear first, 
// followed by elements equal to A[i], followed by elements greater than A[i],
// Your algorithm. should have O(1) space complexity and O(n) time complexity.
// Page 52. Solution page 183

public class DutchFlag {
	public static void dutchFlagSort(Comparable a[], Comparable pivot) {
		int l = 0;
		int r = a.length-1;
		int count = 0;
		Comparable temp;

		for(int i=0; i<a.length; i++) {
			if(a[i].compareTo(pivot)<0) {
				count++;
			}
		}

		while(l<count && r>count) {
			while(a[l].compareTo(pivot)<0 && l<count) {
				l++;
			}
			while(a[r].compareTo(pivot)>0 && r>count) {
				r--;
			}

			if(a[l].compareTo(pivot)!=0 && (a[r].compareTo(pivot)!=0)) {
				temp = a[l];
				a[l] = a[r];
				a[r] = temp;
				l++;
				r--;
			}

			if(a[l].compareTo(pivot)==0 && l<count) {
				temp = a[l];
				a[l] = a[count];
				a[count] = temp;
				l++;
				count++;
			}

			if(a[r].compareTo(pivot)==0 && r>count) {
				temp = a[r];
				a[r] = a[count];
				a[count] = temp;
				r--;
				count++;
			}
		}
	}


	// Main
	public static void main(String args[]) {
		Integer a[] = {5,4,6,5,3,7,1,2,9,8,5};

		System.out.println("Original Array: ");
		for(Integer i : a) {
			System.out.print(i + " ");
		}
		System.out.println();

		dutchFlagSort(a, 5);

		for(Integer i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}