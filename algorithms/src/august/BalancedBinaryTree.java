package august;

import java.util.LinkedList;
import java.util.Queue;

public class BalancedBinaryTree {
	
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
	
	public int height(TreeNode root) {
		if (root == null) return 0;
		else return Math.max(height(root.left), height(root.right)) + 1;
	}

    public boolean isBalanced(TreeNode root) {
    	
    	if (root == null) return true;
    	else { // If the left subtree and right subtree differ in height by less than 1
    		   // and both left and right subtrees are balanced
    		return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    	}
    }
}
