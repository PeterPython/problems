// Problem 10.5: Design an O(n logk) time algorithm that reads
// a sequence of n elements and for each element, starting from
// the k-th element, prints the k-th largest element read up to 
// that point. The length of the sequence is not known in advance. 
// Your algorithm cannot use more than O(k) additional storage. 
// Page 81. Solution 253

import java.util.PriorityQueue;

public class GetKthLargest {
	private PriorityQueue<Integer> pq;
	private int k;

	GetKthLargest(int k) {
		pq = new PriorityQueue<Integer>();
		this.k = k;
	}

	public void add(int i) {
		if(pq.size() < k) {
			pq.add(i);
		}
		else {
			if(pq.peek() <= i) {
				pq.poll();
				pq.add(i);
			}
		}
	}

	public int getKthLargest() {
		return pq.peek();
	}


	// Main
	public static void main(String args[]) {
		GetKthLargest list = new GetKthLargest(3);

		list.add(1);
		list.add(2);
		System.out.println(list.getKthLargest());  // 1
		list.add(3);
		System.out.println(list.getKthLargest());  // 1
		list.add(4);
		System.out.println(list.getKthLargest());  // 2
		list.add(5);
		System.out.println(list.getKthLargest());  // 3
	}
}