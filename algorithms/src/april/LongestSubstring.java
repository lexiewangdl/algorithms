package april;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Given a string s, find the length of the longest substring without repeating characters.
public class LongestSubstring {
	
	// This method has runtime O(n^2)
	public int lengthOfLongestSubstring(String s) {
		int maxLen = 0;

		for (int i = 0; i < s.length(); i++) {
			int length = 1;
			char first = s.charAt(i);
			String sub = first + "";

			for (int j = i + 1; j < s.length(); j++) {
				String cur = s.charAt(j) + "";
				if (!sub.contains(cur)) {
					sub += cur;
					length += 1;
				} else if (sub.contains(cur)) {
					break;
				}
			}

			maxLen = (length > maxLen) ? length : maxLen;
		}
		return maxLen;
	}
	
	// O(n) solution
	public int lengthOfSubstring(String s) {
		Map<Character, Integer> m = new HashMap<>();
		int ind = 0, len = 0;
		
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			
			if (m.containsKey(cur)) {
				ind = m.get(cur) + 1;
			}
			m.put(cur, i);
			len = (len > (i - ind + 1)) ? len : (i - ind + 1);
		}
		
		return len;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LongestSubstring ls = new LongestSubstring();
		String test = scanner.next();
		System.out.println(ls.lengthOfLongestSubstring(test));
		System.out.println(ls.lengthOfSubstring(test));
	}
}
