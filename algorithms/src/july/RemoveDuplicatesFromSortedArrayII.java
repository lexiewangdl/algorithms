package july;

// 80
public class RemoveDuplicatesFromSortedArrayII {
	
    public int removeDuplicates(int[] nums) {
    	
    	// The first 2 elements of array can always be kept
    	// No need for further action
    	if (nums.length <= 2)
    		return nums.length;
    	
    	int t = 2, c = t;
    	while (c < nums.length) {
    		if (nums[t-2] != nums[c]) {
    			nums[t] = nums[c];
    			++t;
    		} 
    		++c;
    	}
    	
    	return t;
    }

}
