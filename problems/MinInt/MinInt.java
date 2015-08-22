// Task 2

// you can also use imports, for example:
import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class MinInt {
    public int solution(int[] A, int[] B) {
        HashSet<Integer> set = new HashSet<Integer>();
        int min = Integer.MAX_VALUE;

        // Add each integer from A to a hashset
        for(int i=0; i<A.length; i++) {
            set.add(A[i]);
        }

        Boolean contains = false;
        for(int i=0; i<B.length; i++) {
            int num = B[i];

            // Check if the set contains any number from B
            if(set.contains(num)) {
                contains = true;
                // Keep track of the minimum
                if(num <= min) {
                    min = num;
                }
            }
        }

        if(contains) {
            return min;
        }

        return -1;
    }
}