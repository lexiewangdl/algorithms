package april;

import java.util.Scanner;

public class Palindromic {
	public static int findMax(int a, int b) {
		return a >= b ? a : b;
	}
	
	public String longestPalindrome(String s) {
		String result = "";
		
		if (s == null || s.length() < 1) return result;

		int start = 0, end = 0;
		
		for (int i = 0; i < s.length(); i++) {
			int lcc = expand(s, i, i);
			int lsc = expand(s, i, i + 1);
			
			int longer = findMax(lcc, lsc);
			
			if (longer > end - start) {
				if (longer == lcc) {
					start = i - ((lcc - 1)/2);
					end =  i + ((lcc - 1)/2);
				} else if (longer == lsc) {
					start = (i + 1) - (lsc/2);
					end = i + (lsc/2);
				}
			}
		}
		
		result = s.substring(start+1, end);
		
		return result;
	}
	
	public static int expand(String s, int start, int end) {
		int i = start, j = end;
		
		while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
			i--;
			j++;
		}
		
		// Return length of palindromic substring found
		return (j - i + 1);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Palindromic p = new Palindromic();
		
		String test = scanner.next();
		System.out.println(p.longestPalindrome(test));
	}
	
}
