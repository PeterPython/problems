/*
Odd Man Out problem 
You're  given  an  unsorted  array  of  integers  where  every  integer  appears  exactly  TWICE,  
except  for  one  integer  which  appears  only  once. Write  an  algorithm  (in  a  language  
of  your  choice)  that  finds  the  integer  that  appears  only  once.
Source: http://courses.csail.mit.edu/iap/interview/Hacking_a_Google_Interview_Practice_Questions_Person_B.pdf
These will not work if the integers appear more than twice
*/

import java.util.HashSet;

public class OddManOut {

	// Using XOR.
	public static int oddManOut(int a[]) {
		int var = 0;
		for(int i=0; i<a.length; i++) {
			var ^= a[i];
		}
		return var;
	}

	// Using HashSet
	public static int oddManOutHash(int a[]) {
		HashSet<Integer> hash = new HashSet<Integer>();
		int sum = 0;

		for(int i=0; i<a.length; i++) {
			if(!hash.contains(a[i])) {
				hash.add(a[i]);
				sum += a[i];
			}
			else if(hash.contains(a[i]))  {
				sum -= a[i];
			}
		}
		return sum;
	}


	// Main
	public static void main(String args[]) {
		// Number 2 does not repeat
		int a[] = {1,2,3,4,5,1,3,4,5};

		System.out.println(oddManOut(a));

		System.out.println(oddManOutHash(a));
	}
}