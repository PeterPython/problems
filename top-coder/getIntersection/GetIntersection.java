// http://community.topcoder.com/stat?c=problem_statement&pm=13672&rd=16314&rm=325220&cr=23006590
// Let X be the last integer you wrote. If X is odd, the game ends. 
// Otherwise, divide X by 2 and write down the result.
// You are given the ints A and B. Return the number of integers 
// that were written both by Taro and by Jiro.

import java.util.*;

public class GetIntersection {
	public static int getIntersection(int a, int b) {
		int greater = a>=b ? a : b;
		int less = a<=b ? a : b;
		int index = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		while(greater%2 == 0) {
			map.put(greater, index++);
			greater = greater/2;
		}
		map.put(greater, index);

		while(less%2 == 0) {
			if(map.containsKey(less)) {
				return map.size() - map.get(less);
			}
			less = less/2;
		}
		if(map.containsKey(less)) {
			return map.size() - map.get(less);
		}

		return 0;
	}


	// Main
	public static void main(String args[]) {
		System.out.println(getIntersection(8, 1));  // 1
		System.out.println(getIntersection(8, 8));  // 4
		System.out.println(getIntersection(8, 4));  // 3
		System.out.println(getIntersection(1, 1));  // 1
		System.out.println(getIntersection(5, 5));  // 1
	}
}