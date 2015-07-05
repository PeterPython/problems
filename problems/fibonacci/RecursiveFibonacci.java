// Recursive Fibonacci

class RecursiveFibonacci {
	private static int fibonacci(int n) {
		if(n==0) {
			return 0;
		} else if(n==1) {
			return 1;
		} else {
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}

	public static void main(String args[]) {
		System.out.println("Fibonacci: ");
		System.out.println("Fibonacci(0) = " + fibonacci(0));
		System.out.println("Fibonacci(1) = " + fibonacci(1));
		System.out.println("Fibonacci(2) = " + fibonacci(2));
		System.out.println("Fibonacci(3) = " + fibonacci(3));
		System.out.println("Fibonacci(4) = " + fibonacci(4));
		System.out.println("Fibonacci(5) = " + fibonacci(5));
	}
}