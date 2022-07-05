package july;

public class LengthOfLastWord {
	
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
