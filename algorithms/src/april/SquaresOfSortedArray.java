package april;

import java.util.Scanner;

public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
    	int[] result = new int[nums.length];
    	
    	int neg = -1, pos = 0;
    	
    	// If array has only 1 element
    	if (nums.length == 1) {
    		result[0] = nums[0] * nums[0];
    		return result;
    	}
    	
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] >= 0) { // Find the index of the first positive integer or zero in array
    			pos = i;
    			break;
    		} else { // Find the index of the last negative integer in array
    			neg = i;
    		}
    	}

    	// If array has all negative elements
    	int k = 0;
    	if (nums[nums.length - 1] < 0) {
    		for (int i = nums.length - 1; i >= 0; i--) {
    			result[k] = nums[i] * nums[i];
    			k++;
    		}
    		return result;
    	}
    	
    	
    	// Else
    	int j = 0;
    	while (pos <= nums.length - 1 && neg >= 0) {

    		if (nums[pos] * nums[pos] <= nums[neg] * nums[neg]) {
    			result[j] = nums[pos] * nums[pos];
    			pos++;
    		} else if (nums[pos] * nums[pos] > nums[neg] * nums[neg]) {
    			result[j] = nums[neg] * nums[neg];
    			neg--;
    		}
    		j++;
    	}
    	
    	while (neg >= 0) {
    		result[j] = nums[neg] * nums[neg];
    		neg--;
    		j++;
    	}
    	
    	while (pos <= nums.length - 1) {
    		result[j] = nums[pos] * nums[pos];
    		pos++;
    		j++;
    	}

        return result;
    }
    
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	SquaresOfSortedArray sosa = new SquaresOfSortedArray();
    	int n = sc.nextInt();
    	int[] nums = new int[n];
    	for (int i=0; i < n; i++) {
    		nums[i] = sc.nextInt();
    	}
    	int[] res = sosa.sortedSquares(nums);
    	for (int i=0; i < res.length; i++) {
    		System.out.print(res[i] + " ");
    	}
    }
	
}
