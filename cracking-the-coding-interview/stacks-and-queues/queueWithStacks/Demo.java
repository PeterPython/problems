// Demo for Problem 3.5: Implement a MyQueue class which implements a queue using two stacks.
// Page 81. Solution 213

public class Demo {
	public static void main(String args[]) {
		MyQueue<Integer> queue = new MyQueue<Integer>();

		System.out.println("Is queue empty? " + queue.isEmpty());
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);

		System.out.println("Is queue empty? " + queue.isEmpty());

		System.out.println("remove() " + queue.remove());
		System.out.println("remove() " + queue.remove());
		System.out.println("remove() " + queue.remove());
		System.out.println("remove() " + queue.remove());

		System.out.println("Is queue empty? " + queue.isEmpty());

		queue.add(1);
		System.out.println("remove() " + queue.remove());

		System.out.println("Is queue empty? " + queue.isEmpty());	
		queue.add(2);
		System.out.println("remove() " + queue.remove());
		queue.add(3);
		System.out.println("remove() " + queue.remove());
		queue.add(4);
		System.out.println("remove() " + queue.remove());

		System.out.println("Is queue empty? " + queue.isEmpty());
	}
}