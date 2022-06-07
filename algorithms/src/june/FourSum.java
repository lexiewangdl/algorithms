package june;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
    	Arrays.sort(nums);
    	
    	return kSum(nums, target, 0, 4);
    }
	
    public List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
    	List<List<Integer>> res = new ArrayList<>();
    	
    	if (k == 2)
    		return twoSum(start, nums, target);
    	
    	for (int i = start; i < nums.length; i++) {
    		if (i == start || nums[i-1] != nums[i]) {
    			for (List<Integer> sub : kSum(nums, target - nums[i], i+1, k-1)) {
    				res.add(new ArrayList<>(Arrays.asList(nums[i])));
    				res.get(res.size() - 1).addAll(sub);
    			}
    		}
    	}
    	
    	return res;
    }
	
	public List<List<Integer>> twoSum(int start, int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		int lo = start, hi = nums.length - 1;
		
		while (lo < hi) {
			if (nums[lo] + nums[hi] < target || (lo > start && nums[lo] == nums[lo-1]))
				lo++;
			else if (nums[lo] + nums[hi] > target || (hi < nums.length-1 && nums[hi] == nums[hi+1]))
				hi--;
			else {
				List<Integer> temp = new ArrayList<>();
				temp.add(nums[lo]);
				temp.add(nums[hi]);
				result.add(temp);
				lo++;
				hi--;
			}
		}
		
		return result;
	}

}
