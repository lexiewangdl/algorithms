package may;

public class LongestCommonPrefix {
	public static boolean isCommonPrefix(String t, String[] strs) {
		for (String s : strs) {
			if (!s.startsWith(t))
				return false;
		}
		
		return true;
	}
	
    public String longestCommonPrefix(String[] strs) {
    	int shortestLen = Integer.MAX_VALUE;
    	String shortest = "";
        for (String str : strs) {
        	if (str.length() <= shortestLen) {
        		shortestLen = str.length();
        		shortest = str;
        	}
        }
        
        int l = 1;
        int h = shortestLen;
        
        while (l <= h) {
        	int m = (l + h)/2;
        	String temp = shortest.substring(0, m);
        	if (isCommonPrefix(temp, strs))
        		l = m + 1;
        	else
        		h = m - 1;
        }
        
        return shortest.substring(0, (l+h)/2);
    }

}
