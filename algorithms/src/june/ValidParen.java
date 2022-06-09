package june;

import java.util.Scanner;
import java.util.Stack;

public class ValidParen {
	
    public boolean isValid(String s) {
    	if (s == null)
    		return true;
    	
        Stack<String> stack = new Stack<String>();
        
        for (int i = 0; i < s.length(); i++) {
        	String current = s.charAt(i) + "";

        	if (current.equals("(")|| current.equals("[") || current.equals("{")) {
        		stack.push(current);
        	}
        	
        	else if (current.equals(")")|| current.equals("]") || current.equals("}")) {
        		if (stack.isEmpty())
        			return false;
        		
        		String top = stack.peek();
        		
        		if ((current.equals(")") && top.equals("(")) || (current.equals("]") && top.equals("[")) || (current.equals("}") && top.equals("{"))) {
            		stack.pop();
            	} else
            		return false;
        	}
        }

        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	ValidParen vp = new ValidParen();
    	String input = sc.next();
    	System.out.println(vp.isValid(input));
    }

}
