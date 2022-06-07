package june;

import java.util.ArrayList;
import java.util.List;

public class LetterCombOfPhoneNum {
	
    public List<String> letterCombinations(String digits) {
    	
    	List<String> combinations = new ArrayList<String>();
    	
    	if (digits == null || digits.length() == 0)
    		return combinations;
    	
    	char[][] cArr= {
    		    {'a','b', 'c'},
    		    {'d','e','f'},
    		    {'g','h','i'},
    		    {'j','k','l'},
    		    {'m','n','o'},
    		    {'p','q','r','s'},
    		    {'t','u','v'},
    		    {'w','x','y','z'}};
    	
    	combinations = help(digits, new StringBuilder(), combinations, cArr);
    	
        return combinations;
    }
    
    public List<String> help(String s, StringBuilder ans, List<String> comb, char[][] arr) {
    	if (s.length() == 0) {
    		comb.add(ans.toString());
    		return comb;
    	}
    	for (char c : arr[s.charAt(0)-'2']) {
    		help(s.substring(1), ans.append(c), comb, arr);
    		ans.deleteCharAt(ans.length()-1);
    	}
    	return comb;
    }

}
