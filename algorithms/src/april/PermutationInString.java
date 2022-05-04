package april;

import java.util.Arrays;

// A Permutation of a string is another string that contains same characters, 
// only the order of characters can be different

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
    	
    	int a = s1.length(), b = s2.length();
    	
    	if (a > b)
    		return false;
    	
    	// Initialize the two arrays, storing the count of the first a characters
    	// in string1 and string2 separately in arr1 and arr2
    	int[] arr1 = new int[26];
    	int[] arr2 = new int[26];

    	for (int i = 0; i < a; i++) {
    		arr1[s1.charAt(i) - 'a']++;
    		arr2[s2.charAt(i) - 'a']++; 
    	}
    	
    	for (int i = a; i < b; i++) {
    		if (Arrays.equals(arr1, arr2))
    			return true;
    		
    		arr2[s2.charAt(i - a) - 'a']--;
    		arr2[s2.charAt(i) - 'a']++;
    	}
    	
    	if (Arrays.equals(arr1, arr2))
    		return true;
    	
    	return false;
    }

}
