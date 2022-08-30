package august;

public class SymmetricTree {
	
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode() {}
	     TreeNode(int val) { this.val = val; }
	     TreeNode(int val, TreeNode left, TreeNode right) {
	         this.val = val;
	         this.left = left;
	         this.right = right;
	     }
	 }
	 
	 public boolean isSymmetric(TreeNode root) {
	     if (root == null) return true;
	     return solve(root.left, root.right);
	 }
	    
	 public boolean solve(TreeNode left, TreeNode right) {
		 
		 // If both left node and right node are null, the two are symmetric
		 // We've reached end of tree
		 if (left == null && right == null) return true;
		 
		 // If either left or right is null, NOT symmetric
		 else if (left == null || right == null) return false;
		 
		 // If values don't equal, NOT symmetric
		 if (left.val != right.val) return false;
		 
		 // Do the same for left's children and right's children
		 return solve(left.left, right.right) && solve(left.right, right.left);
	 }

}
