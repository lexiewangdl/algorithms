package april;

import java.util.Scanner;

public class BinarySearch {
	
	public static int search(int[] nums, int target) {
		int l = 0, r = nums.length - 1;

		while (l <= r) {
			int pivot = l + (r-l)/2;
			if (nums[pivot] == target)
				return pivot;
			if (target < nums[pivot]) {
				r = pivot - 1;
			} else if (target > nums[pivot]) {
				l = pivot + 1;
			}
		}

		return -1;
    }
	
	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int[] arr = new int[num];
		for (int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();
		}
		
		int target = sc.nextInt();
		
		System.out.println(search(arr, target));
		
	}

}
