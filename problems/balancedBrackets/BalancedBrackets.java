import java.util.HashMap;
import java.util.Stack;

public class BalancedBrackets {
	public static boolean isBalanced(String str) {
		HashMap<Character, Character> openBrackets = new HashMap<Character, Character>();
		openBrackets.put('(', ')');
		openBrackets.put('{', '}');
		openBrackets.put('[', ']');

		str = str.replaceAll("[^\\(\\)\\{\\}\\[\\]]", "");

		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<str.length(); i++) {
			if(openBrackets.containsKey(str.charAt(i))) {
				stack.push(str.charAt(i));
			}
			else if(!stack.isEmpty()) {
				char top = stack.peek();
				if(str.charAt(i) == openBrackets.get(top)) {
					stack.pop();
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}

		if(!stack.isEmpty()) {
			return false;
		}

		return true;
	}

	public static void main(String args[]) {
		System.out.println(isBalanced("([]{})"));

		String st = "[(5+3)+[2]*[7]{5+(6)}]";
		System.out.println(st + " = " + isBalanced(st));

		st = "[(5+3)+[2]*[7]{5+(6)}";
		System.out.println(st + " = " + isBalanced(st));

		st = ")(3+2)";
		System.out.println(st + " = " + isBalanced(st));

		st = "(3+2)]";
		System.out.println(st + " = " + isBalanced(st));

		st = "(3+[2)]";
		System.out.println(st + " = " + isBalanced(st));
	}
}