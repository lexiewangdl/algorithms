package april;

import java.util.Scanner;

public class RotateArray {

	public void rotate(int[] nums, int k) {
		
		if (nums.length != 1) {
			
			if (k > nums.length)
				k = k % nums.length;
		
			int[] stack = new int[k];
		
			int j = 0;
			for (int i = nums.length - k; i < nums.length; i++) {
				stack[j] = nums[i];
				j++;
			}
			for (int i = nums.length - 1; i >= k; i--) {
				nums[i] = nums[i-k];
			}
			for (int i = 0; i < k; i++) {
				nums[i] = stack[i];
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		RotateArray ra = new RotateArray();
		
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		
		ra.rotate(nums, k);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
