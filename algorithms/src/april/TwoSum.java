package april;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

public class TwoSum{
    public int[] twoSum(int[] nums, int target) {
    	HashMap<Integer, Integer> table = new HashMap<>();
    	
    	// Returning array of size 2
    	int[] result = new int[2];
    	
    	// Put input numbers in a hash table
    	for (int i = 0; i < nums.length; i++) {
    		table.put(nums[i], i);
    	}
    	
    	for (int i = 0; i < nums.length; i++) {
    		int n = nums[i];
    		int difference = target - n;

    		if (table.containsKey(difference) && table.get(difference) != i) {
    			result[0] = i;
    			result[1] = table.get(difference);
    			}
    		}
    	return result;
    	}

    
    public static void main(String[] args) {
    	TwoSum ts = new TwoSum();
    	Scanner scanner = new Scanner(System.in);
    	int n = scanner.nextInt();
    	int[] nums = new int[n];
    	for (int i = 0; i < n; i++) {
    		nums[i] = scanner.nextInt();
    	}
		int t = scanner.nextInt();
    	int[] a = ts.twoSum(nums, t);
    	System.out.println(a[0] + " " + a[1]);
    
    }
    
}


