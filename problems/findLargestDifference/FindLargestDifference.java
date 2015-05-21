// Maximum difference between two elements such that larger element appears after the smaller number
// http://www.geeksforgeeks.org/maximum-difference-between-two-elements/

public class FindLargestDifference {
	public static int findLargestDifference(int a[]) {
		int maxDiff = a[1] - a[0];
		int min = a[0];

		for(int i=1; i<a.length; i++) {
			if((a[i] - min) > maxDiff) {
				maxDiff = a[i] - min;
			}
			if(a[i] < min) {
				min = a[i];
			}
		}

		return maxDiff;
	}


	// Main
	public static void main(String args[]) {
		int a[] = {5,3,4,2,7,8};
		System.out.println(findLargestDifference(a));
	}
}