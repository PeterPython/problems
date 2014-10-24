class IterativeFibonacci {
	public static void main(String args[]) {
		System.out.println("Fibonacci: ");
		System.out.println("Fibonacci(0) = " + fibonacci(0));
		System.out.println("Fibonacci(1) = " + fibonacci(1));
		System.out.println("Fibonacci(2) = " + fibonacci(2));
		System.out.println("Fibonacci(3) = " + fibonacci(3));
		System.out.println("Fibonacci(4) = " + fibonacci(4));
		System.out.println("Fibonacci(5) = " + fibonacci(5));
	}

	private static int fibonacci(int n) {
		int f=0, f1=0, f2=1;
		if(n == 1) {
			f = f2 = 1;
		} else {
			for(int i=1; i<n; i++) {
				f = f1 + f2;
				f1 = f2;
				f2 = f;
			}
		}
		return f;
	}
}