package april;

import java.util.Scanner;

public class MoveZeros {
	public void moveZeroes(int[] nums) {
		int[] new_nums = new int[nums.length];

		int j = 0;
		if (nums.length > 1) {
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] != 0) {
					new_nums[j] = nums[i];
					j++;
				}
			}

			while (j < nums.length) {
				new_nums[j] = 0;
				j++;
			}
			
			for (int i = 0; i < nums.length; i++) {
				nums[i] = new_nums[i];
			}
		}
	}
	
	public void moveZeros(int[] nums) {
		int pointer = 0;
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[pointer] = nums[i];
				pointer++;
			}
		}
		
		while (pointer < nums.length) {
			nums[pointer] = 0;
			pointer++;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MoveZeros mz = new MoveZeros();
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		
		mz.moveZeros(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
