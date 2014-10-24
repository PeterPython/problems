// Problem: Find the most frequent integer in an array

class MostFrequentInt {
	public static void main(String args[]) {
		int intArray[] = {1, 3, 4, 2, 1, 4, 5, 3, 5, 3, 2, 3};
		int mostFrequent = getMostFrequentInt(intArray);
		System.out.println("Most frequent int in array is: " + mostFrequent);
	}

	static int getMostFrequentInt(int n[]) {
		java.util.Arrays.sort(n);
		int mostCount = 0;
		int currentCount = 0;
		int most = n[0];

		for(int i=0; i<n.length-1; i++) {
			if(n[i] == n[i+1]) {
				currentCount++;
					if(currentCount > mostCount) {
						mostCount = currentCount;
						most = n[i];
					}
			} else {
				currentCount = 0;
			}
		}

		return most;
	} 
}

