public class DynamicFibonacci {
	public static int fibonacci(int n) {
		int a[] = new int[n+1];
		return dFibonacci(n, a);
	}

	public static int dFibonacci(int n, int a[]) {
		if(n == 0) {
			a[0] = 0;
			return 0;
		}
		else if(n == 1) {
			a[1] = 1;
			return 1;
		}
		
		else if(n != 0 && a[n] != 0) {
			return a[n];
		}

		a[n] = dFibonacci(n-1, a) + dFibonacci(n-2, a);
		return a[n];
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