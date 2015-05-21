// Problem 10.3: How would you implement a stack API using a heap and a queue API using a heap?
// Page 81. Solution 250

import java.util.*;

public class StackWithHeap<Item extends Comparable<Item>> {
	private PriorityQueue<Integer> pq;
	private HashMap<Integer, Item> map;
	private int order;

	public StackWithHeap() {
		pq = new PriorityQueue<Integer>(Collections.reverseOrder());  // Use comparator to make max PQ
		map = new HashMap<Integer, Item>();
		order = 0;
	}

	public void push(Item item) {
		pq.add(order);
		map.put(order, item);
		order++;
	}

	public Item pop() {
		Item item = null;

		if(!pq.isEmpty()) {
			item = map.get(pq.poll());
			order--;
		}
		return item;
	}


	// Main
	public static void main(String args[]) {
		StackWithHeap<Integer> st = new StackWithHeap<Integer>();
		st.push(1);
		st.push(2);
		st.push(3);
		System.out.println(st.pop()); // 3
		st.push(3);
		System.out.println(st.pop()); // 3
		System.out.println(st.pop()); // 2
		st.push(2);
		st.push(3);
		System.out.println(st.pop()); // 3
		System.out.println(st.pop()); // 2
		System.out.println(st.pop()); // 1
	}
}