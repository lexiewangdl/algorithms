package july;

public class SearchRotatedSortedArray {
	
	// O(log n) solution
	
	public boolean binarySearch(int[] nums, int target, int left, int right) {

		if (left >= right)
			return false;
		
		int mid = left + (right - left) / 2;
		
		if (nums[mid] == target)
			return true;
		
		if (nums[mid] >= nums[left]) {
			if (nums[mid] >= target && nums[left] <= target) 
				binarySearch(nums, target, left, mid-1);
			else
				binarySearch(nums, target, mid+1, right);
		} else if (nums[mid] < nums[left]) {
			if (target <= nums[right] && nums[mid] < target)
				binarySearch(nums, target, mid+1, right);
			else
				binarySearch(nums, target, left, mid-1);
		} else {
			left++;
		}
		
		return false;
	}
	
    public boolean search(int[] nums, int target) {
    	
    	if (nums.length == 1)
    		return (nums[0] == target);

    	return binarySearch(nums, target, 0, nums.length-1);
    }
	
	// O(n) time solution
    public boolean search2(int[] nums, int target) {
    
    	int i = 0;
    	
    	while (nums[i] > target) {
    		i++;
    		if (i >= nums.length)
    			return false;
    	}
    	
    	for (int j = i; j < nums.length; j++) {
    		if (nums[j] == target)
    			return true;
    	}
    	
    	return false;
    }

}
