// Implement the 'cd' command. 
// Given cd("a/b", "c/../d/e/../f") return the final path 
// directory that the user will be when the cd command is executed

import java.util.Stack;

public class CdCommand {
	public static String cdCommand(String current, String to) {
		Stack<String> st = new Stack<String>();
		String dir = current + "/" + to;
		String a[] = dir.split("/");

		for(int i=0; i<a.length; i++) {
			if(a[i].equals("..") && !st.isEmpty()) {
				st.pop();
			}
			else {
				st.push(a[i]);
			}
		}

		StringBuilder builder = new StringBuilder();
		Stack<String> reverse = new Stack();

		while(!st.isEmpty()) {
			reverse.push(st.pop());
		}

		while(!reverse.isEmpty()) {
			builder.append(reverse.pop());
			builder.append("/");
		}

		return builder.toString();
	}


	public static void main(String args[]) {
		System.out.println(cdCommand("a/b", "c/../d/e/../f"));
	}
}