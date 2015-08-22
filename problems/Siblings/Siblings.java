// Task 1

// you can also use imports, for example:
import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Siblings {
    public int solution(int N) {
        String num = String.valueOf(N);
        int a[] = new int[num.length()];
        int number = N;
        
        for(int i=0; i<num.length(); i++) {
            a[i] = num.charAt(i) - '0';  // Converting char to int
        }
        
        Arrays.sort(a);
        StringBuilder builder = new StringBuilder();
        
        // Adding each digit into a builder
        for(int i=a.length-1; i>=0; i--) {
            builder.append(String.valueOf(a[i]));
        }
        
        String max = builder.toString();
        
        return Integer.parseInt(max);
    }
}