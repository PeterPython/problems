// Task 3

// you can also use imports, for example:
import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Similar {
    public int solution(int N) {
        if(N > 99999 || N < 0) {
            throw new RuntimeException("Number out of range");
        }
        String num = String.valueOf(N);
        HashSet<Integer> set = new HashSet<Integer>();

        // Get permutations of the string/number and add each into a set
        getPermutations("", num, set);

        return set.size();
    }

    public void getPermutations(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();

        if(n == 0) {
            set.add(Integer.parseInt(prefix));
        }

        for(int i=0; i<n; i++) {
            getPermutations(prefix + str.charAt(i), str.substring(0,i) + str.substring(i+1), set);
        }
    }
}