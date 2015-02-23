// https://codersupremo.wordpress.com/2013/05/09/topcoder-practice-rooms-srm-144-div-1/

public class BinaryCode {
	public static String[] decode(String str) {
		String[] answer = new String[2];
		int[] intA = new int[str.length()];
		int[] p = new int[str.length()];
		boolean valid = true;

		for(int i=0; i<str.length(); i++) {
			intA[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
		}

		for(int k=0; k<2; k++) {
			p[0] = k;
			for(int i=1; i<p.length; i++) {
				if(i > 1) {
					p[i] = intA[i-1] - p[i-1] - p[i-2];
				}
				else {
					p[i] = intA[i-1] - p[i-1];
				}
				if(p[i] != 0 && p[i] != 1) {
					answer[k] = "NONE";
					valid = false;
					break;
				}
			}

			if(valid) {
				StringBuilder ans = new StringBuilder();
				for(int i=0; i<p.length; i++) {
					ans.append(String.valueOf(p[i]));
				}
				answer[k] = ans.toString();
			}
			valid = true;
		}
		return answer;
	}


	// Main
	public static void main(String args[]) {
		String a[] = decode("123210122");
		for(int i=0; i<2; i++) {
			System.out.println(a[i]);
		}
	}
}