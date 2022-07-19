package july;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	
	/* 
	 * G(n) is a sequence of 2^n integers where 
	 * the first integer is 0,
	 * an integer appears no more than once in the sequence,
	 * the binary representation of every pair of adjacent integers differ by exactly one bit
	 * the binary representation of the first and last integers differ by exactly one bit
	 */
	
	/*
	 * How to find G(n+1) from G(n)?
	 * To get first half of G(n+1), we add a 0 to the front of every integer in G(n),
	 * getting G'(n)
	 * To get the second half of G(n+1), we put G(n) in reverse order to get R(n),
	 * and we add a 1 to the front of every integer in R(n)
	 * G(n+1) is made up of G'(n) and R(n)
	 */
	
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(0);
        
        int head = 1; // Add to the front of G(n-1) in reverse order
        
        for (int i = 0; i < n; i++) {
        	for (int j = res.size() - 1; j >= 0; j--) {
        		res.add(head+res.get(j));
        	}
        	// Shifts the bits of the number to the left for 1 position
        	// For every n, we only do this once; because for every n, the
        	// binary representations of integers are of same length.
        	// Shift to the left for 1 place when we move on to next n
        	head <<= 1; 
        }
        
        return res;
    }

}
