package june;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {

		List<List<Integer>> result = new ArrayList<>();

		if (nums.length == 0)
			return result;

		boolean[] used = new boolean[nums.length];

		List<Integer> wip = new ArrayList<>();

		dfs(nums, 0, wip, used, result);

		return result;
	}

	public void dfs(int[] nums, int depth, List<Integer> wip, boolean[] used, List<List<Integer>> res) {

		if (depth == nums.length) { // We have reached bottom of tree
			res.add(new ArrayList<>(wip));
			return;
		}

		// If we haven't reached any of the leaves
		for (int i = 0; i < nums.length; i++) {
			if (!used[i]) { // If the i-th number has not been used
				wip.add(nums[i]); // Add it to the permutation we're building
				used[i] = true; // Mark it as used

				dfs(nums, depth + 1, wip, used, res);

				// »ØËİ
				used[i] = false;
				wip.remove(wip.size() - 1);

			}
		}
	}
}
