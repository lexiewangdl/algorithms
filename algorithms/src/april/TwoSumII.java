package april;

import java.util.Scanner;

/*
 * Given an 1-indexed array of integer that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number.
 * Return the 1-based indices of the two numbers.
 * The solution must use only constant extra space.
 */

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        
        int dIdx = numbers.length - 1;
        int nIdx = 0;
        
        while (dIdx > nIdx) {
        	int difference = target - numbers[nIdx];
        	
        	while (numbers[dIdx] > difference) {
        		dIdx--;
        	}
        	
        	if (numbers[dIdx] == difference) {
        		result[0] = nIdx + 1;
        		result[1] = dIdx + 1;
        		break;
        	}
        	nIdx++;
        }
        
    	return result;
    }
    
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	TwoSumII tsi = new TwoSumII();
    	
    	int n = sc.nextInt();
    	int[] nums = new int[n];
    	for (int i = 0; i < n; i++) {
    		nums[i] = sc.nextInt();
    	}
    	int t = sc.nextInt();
    	
    	int[] res = tsi.twoSum(nums, t);
    	for (int i = 0; i < res.length; i++) {
    		System.out.print(res[i] + " ");
    	}
    }
}
