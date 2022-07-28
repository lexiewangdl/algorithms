package july;

import java.util.ArrayList;
import java.util.LinkedList;

public class ValidateBST {
	
	// In-order Traversal, DFS
	
	LinkedList<TreeNode> stack = new LinkedList();
	LinkedList<Integer> uppers = new LinkedList();
	LinkedList<Integer> lowers = new LinkedList();

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	public void update(TreeNode root, Integer lower, Integer upper) {
		stack.add(root);
		uppers.add(upper);
		lowers.add(lower);
	}

	public boolean isValidBST(TreeNode root) {
		Integer lower = null, upper = null, val;
		update(root, lower, upper);
		
		while (!stack.isEmpty()) {
			root = stack.poll();
			lower = lowers.poll();
			upper = uppers.poll();
			
			if (root == null) continue;
			val = root.val;
			if (lower != null && val <= lower) return false;
			if (upper != null && val >= upper) return false;
			update(root.right, val, upper);
			update(root.left, lower, val);
		}
		return true;
    }
}
