// Given an array of integers, find two numbers such that they add up to a specific target number.
// https://leetcode.com/problems/two-sum/

public class TwoSum {
	public static int[] twoSumTo(int a[], int n) {
		int index[] = new int[2];

		for(int i=0; i<a.length; i++) {
			for(int j=i+1; j<a.length; j++) {
				if(a[i]+a[j] == n) {
					index[0] = i;
					index[1] = j;
					return index;
				}
			}
		}

		return index;
	}


	public static void main(String args[]) {
		int a[] = {3,2,1,4,5,6,9,6,7};
		int index[] = twoSumTo(a, 15);

		for(int i : index) {
			System.out.println(i);
		}
	}
}