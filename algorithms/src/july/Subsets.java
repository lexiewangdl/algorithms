package july;

import java.util.List;
import java.util.ArrayList;

public class Subsets {

	List<List<Integer>> res = new ArrayList<>();

	public void backtrack(List<Integer> cur, int start, int k, int[] nums) {
		if (k == 0) {
			res.add(new ArrayList<Integer>(cur));
			return;
		}
		for (int i = start; i < nums.length; i++) {
			cur.add(nums[i]);
			backtrack(cur, i + 1, k - 1, nums);
			cur.remove(cur.size() - 1);
		}

	}

	public List<List<Integer>> subsets(int[] nums) {

		if (nums.length == 0)
			return res;
		
		for (int k = 0; k <= nums.length; k++) {
			backtrack(new ArrayList<Integer>(), 0, k, nums);
		}

		return res;

	}

}
