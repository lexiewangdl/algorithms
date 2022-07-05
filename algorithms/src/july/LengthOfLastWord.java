package july;

public class LengthOfLastWord {
	
	// 内存消耗更少
    public int lengthLastWord(String s) {
        int index = s.length() - 1;
        while (s.charAt(index) == ' ') {
            index--;
        }
        int wordLength = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            wordLength++;
            index--;
        }
        return wordLength;
    }

	
    public int lengthOfLastWord(String s) {

    	String[] splitted = s.split(" ");
    	
    	String res = "";
    	for (int i = splitted.length - 1; i >= 0; i--) {
    		if (splitted[i] == null || splitted[i] == "") 
    			continue;
    		else {
    			res = splitted[i];
    			break;
    		}
    	}
    	
    	return res.length();
    }

}
