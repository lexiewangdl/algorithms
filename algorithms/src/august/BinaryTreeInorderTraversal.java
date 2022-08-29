package august;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

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
	 
	 List<Integer> result = new ArrayList<Integer>();
	 
	 public void traverse(TreeNode root) {
		 if (root == null) return;
		 else {
			 traverse(root.left);
			 result.add(root.val);
			 traverse(root.right);
		 }
	 }
	 
	 public List<Integer> inorderTraversal(TreeNode root) {
		 traverse(root); 
		 return result;
	 }

}
