package june;

import java.util.Scanner;

public class MultiplyString {
	
    public String multiply(String num1, String num2) {
    	
    	int res = 0;
        
    	int multiplier1 = 1;
    	
    	for (int i = num1.length() - 1; i >= 0; i--) {
    		int cur1 = Character.getNumericValue(num1.charAt(i));
    		
    		int multiplier2 = 1;
    		
    		for (int j = num2.length() - 1; j >= 0; j--) {
    			int cur2 = Character.getNumericValue(num2.charAt(j));
    			
    			res += (cur2 * multiplier2) * (cur1 * multiplier1);
    			
    			multiplier2 *= 10;
    		}
    		
    		multiplier1 *= 10;
    	}
    	
    	String result = String.valueOf(res);
    			
    	return result;
    }
    
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	MultiplyString ms = new MultiplyString();
    	
    	String str1 = sc.next();
    	String str2 = sc.next();
    	
    	System.out.println(ms.multiply(str1, str2));
    }

}
