// Get the mim average of a subarray. Min length of subarray is 2

public class MimAverage {
	public static void main(String args[]) {
		int a[] = {1, 3, 1, 2, 4};

		System.out.println(getMinAverage(a));
	}


	public static String getMinAverage(int a[]) {
		int sum = 0;
		double count;
		double average;
		String index = "";
		double min = Double.POSITIVE_INFINITY;
		String minString = "";
		String str = "";

		for(int i=0; i<a.length-1; i++) {
			index = "";
			count = 2;
			sum = a[i] + a[i+1];
			average = sum / count++;
			index = i + ", " + (i+1) + ", "; 
			str = index + " = " + sum + ", Average = " + average;
			System.out.println(str);
			if(average < min) {
				min = average;
				minString = "\nMinimum average is the sum of indexs: " + str;
			}
			for(int k=i+2; k<a.length; k++) {
				sum += a[k];
				average = sum / count++;
				index+= k + ", "; 
				str = index + " = " + sum + ", Average = " + average;
				System.out.println(str);
				if(average < min) {
					min = average;
					minString = "\nMin average is the sum of indexs: " + str;
				}
			}
		}

		return minString;
	}
}