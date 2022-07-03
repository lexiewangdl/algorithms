package july;

public class JumpGame {

	public boolean canJump(int[] nums) {

		if (nums.length == 0 || nums == null)
			return false;
		if (nums.length == 1)
			return true;

		boolean[] reachable = new boolean[nums.length];
		reachable[0] = true;

		for (int i = 0; i < nums.length; i++) {
			if (reachable[i]) {
				for (int j = 1; j <= nums[i] && i + j < reachable.length; j++) {
					reachable[i + j] = true;
				}
			}
		}

		if (reachable[nums.length - 1])
			return true;
		
		return false;
	}

	// Better
	public boolean canJum(int[] nums) {

		if (nums.length == 0 || nums == null)
			return false;
		if (nums.length == 1)
			return true;

		int maxJump = 0;

		for (int i = 0; i < nums.length; i++) {
			// Update max jump length
			if (i <= maxJump) {
				maxJump = Math.max(maxJump, i + nums[i]);
				if (maxJump >= nums.length - 1)
					return true;
			}
		}
		return false;
	}

}
