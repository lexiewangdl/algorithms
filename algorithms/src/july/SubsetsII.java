package july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
	
	List<List<Integer>> res = new ArrayList<>();
	
	public void backtrack(List<Integer> cur, int start, int k, int[] nums) {
		if (k == 0) {
			res.add(new ArrayList<Integer>(cur));
			return;
		}
		for (int i = start; i < nums.length; i++) {
			// If i is not the start index, and i-th element is same as previous element
			// Then it's duplicate, move on to next i
			if (i > start && nums[i] == nums[i-1])
				continue;
			
			cur.add(nums[i]);
			backtrack(cur, i + 1, k - 1, nums);
			cur.remove(cur.size() - 1);
		}

	}
	
    public List<List<Integer>> subsetsWithDup(int[] nums) {

    	if (nums.length == 0)
    		return res;
    	
    	// Similar to previous question 78. Subsets, but this time with duplicates
    	// Before looping through individual elements, sort first
    	Arrays.sort(nums);

		for (int k = 0; k <= nums.length; k++) {
			backtrack(new ArrayList<Integer>(), 0, k, nums);
		}
    	
    	return res;
    }

}
