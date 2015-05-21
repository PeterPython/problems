// Given an array of n integers, write a function that shuffles 
// the array in place such that all permutations of the n integers are equally likely
// https://www.youtube.com/watch?v=U0nvXHh7o-w&index=9&list=WL at 4:24

import java.util.Random;

class ShuffleArray {
	public static void shuffle(int a[]) {
		int random;
		int temp;
		Random rn = new Random();

		int n = a.length;
		for(int i=0; i<n; i++) {
			random = rn.nextInt(n);  // Random number between 0-a.length-1

			// Swap
			temp = a[i];
			a[i] = a[random];
			a[random] = temp;
		}
	}

	public static void main(String args[]) {
		int a[] = {1,2,3,4,5,6,7,8};

		System.out.println("Original: ");
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}

		System.out.println("\nShuffle: ");
		shuffle(a);

		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}

		System.out.println();
	}
}