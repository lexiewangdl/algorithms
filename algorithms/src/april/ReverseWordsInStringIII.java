package april;

public class ReverseWordsInStringIII {
	
    public String reverseWords(String s) {
    	
    	char[] str = s.toCharArray();
    	
    	int wordB = 0, wordE = -1;
    	
    	while (wordE < s.length()) {
    		for (int i = 0; i < str.length; i++) {
    			if (str[i] == ' ') { // use single quote, char constant
    				wordE = i - 1;
    				
    				while (wordE > wordB) {
    					char temp = str[wordB];
    					str[wordB] = str[wordE];
    					str[wordE] = temp;
    				}
    				
    				wordB = i + 1;
    			}
    		}
    	}
    	
    	
        String result = "";



        result = result.concat(" ");
   
        
    	return result;
    }
	
	
    public String reverseWordsOld(String s) {
        String result = "";
        
        String[] splitted = s.split(" ");
        
        for (int i = 0; i < splitted.length; i++) {
        	int left = 0, right = splitted[i].length() - 1;
        	char[] chars = splitted[i].toCharArray();
        	
        	while (left < right) {
        		char temp = chars[left];
        		chars[left] = chars[right];
        		chars[right] = temp;
        		left++;
        		right--;
        	}
        	
        	String a = new String(chars);
        	result = result.concat(a);
        	
        	if (i == splitted.length - 1)
        		break;
        	
        	result = result.concat(" ");
        }
        
    	return result;
    }
}
