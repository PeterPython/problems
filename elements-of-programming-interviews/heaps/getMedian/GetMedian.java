// Problem 10.8:  Design an algorithm for computing the running median
// of a sequence. The time complexity should be O(logn) per element 
// read in; where n is the number of values read in up to that element.
// Page 82. Solution 255

import java.util.*;

public class GetMedian {
	private PriorityQueue<Integer> leftMaxPQ;   // Stores the smaller portin of the list, the left side
	private PriorityQueue<Integer> rightMinPQ;   // Stores the large portion of the list, the right side

	public GetMedian() {
		leftMaxPQ = new PriorityQueue<Integer>(Collections.reverseOrder());
		rightMinPQ = new PriorityQueue<Integer>();

	}

	public void add(int i) {
		if(!leftMaxPQ.isEmpty() && i<leftMaxPQ.peek()) {
			leftMaxPQ.add(i);
		}
		else {
			rightMinPQ.add(i);
		}

		// Balancing the lists so their sizes are not too different
		if(rightMinPQ.size() > leftMaxPQ.size() + 1) {
			leftMaxPQ.add(rightMinPQ.poll());
		}
		else if(leftMaxPQ.size() > rightMinPQ.size() + 1) {
			rightMinPQ.add(leftMaxPQ.poll());
		}

		System.out.println("You added: " + i + ", Median so far: " + getMedian());
	}

	public double getMedian() {
		if(leftMaxPQ.size() == rightMinPQ.size()) {  // If they have the same size get the average of the both tops
			return 0.5*(leftMaxPQ.peek()+rightMinPQ.peek());
		}
		else {  // Else return the top of the list with larger size
			return leftMaxPQ.size() > rightMinPQ.size() ? leftMaxPQ.peek() : rightMinPQ.peek();
		}
	}


	// Main
	public static void main(String args[]) {
		GetMedian gm = new GetMedian();

		gm.add(1);
		gm.add(2);
		gm.add(5);
		gm.add(6);
		gm.add(7);
		gm.add(4);
	}
}