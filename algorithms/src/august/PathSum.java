package august;

public class PathSum {
	
	// 112. Path Sum
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) {this.val = val;}
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

    public boolean hasPathSum(TreeNode root, int targetSum) {
    	if (root == null) 
    		return false;
    	if (root.left == null && root.right == null) // If current node is a leaf node,
    		return targetSum == root.val; // See if current node's value is equal to remaining sum
    	return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
