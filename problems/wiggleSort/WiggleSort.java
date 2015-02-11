// Wiggle sort
// Wiggle sort converts the array into alternate increasing decreasing numbers.
// http://www.quora.com/What-is-an-efficient-method-to-wiggle-sort-an-array
// You only need to preserve comparison relations between immediate neighbours

public class WiggleSort {
	public static void wiggleSort(int a[]) {
		int temp;
		for(int i=0; i<a.length-1; i++) {
			if(i%2 == 0) {
				if(a[i] > a[i+1]) {
					temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
				}
			}
			else {
				if(a[i] < a[i+1]) {
					temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
				}
			}
		}
	}


	public static void main(String args[]) {
		int a[] = {43,41,11,13,32,40,17,6,3,4,7,9,1,2,8,5,22,21,20,19,25};
		for(int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();

		wiggleSort(a);
		for(int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}