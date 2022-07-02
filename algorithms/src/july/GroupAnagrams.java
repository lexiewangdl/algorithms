package july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
    	
    	if (strs.length == 0)
    		return Arrays.asList(Arrays.asList(strs));

    	
    	// Each key is the ordered string of characters in original string
    	// Each value is a list of strings that are anagrams
    	Map<String, List<String>> map = new HashMap<String, List<String>>();
    	
    	for (String str : strs) {
    		char[] chars = str.toCharArray(); // Convert string to char array
    		Arrays.sort(chars); // Sort char array
    		String ordered = new String(chars); // Convert sorted array to string
    		
    		// Get the list of strings that matches this ordered string
    		// If there's none, create a new empty list
    		List<String> list = map.getOrDefault(ordered, new ArrayList<String>());
    		
    		list.add(str); // Add current string to list
    		map.put(ordered, list); // Map ordered string to list
    	}
    	
    	return new ArrayList<List<String>>(map.values());
    }
	
}
