package august;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees {
	
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
	
    public List<TreeNode> generateTrees(int n) {
        return solve(1, n);
    }

    // Helper function
    public List<TreeNode> solve(int l, int h) {
    	List<TreeNode> result = new ArrayList<TreeNode>();
    	
    	if (l > h) {
    		result.add(null);
    		return result;
    	}
    	
    	for (int i = l; i <= h; i++) {
    		List<TreeNode> leftSubtree = solve(l, i-1); // All possible left subtrees
    		List<TreeNode> rightSubtree = solve(i+1, h); // All possible right subtrees
    		
    		// Find out all possible BST with root being i
    		for (TreeNode lt : leftSubtree) { // For every possible left subtree, 
    			for (TreeNode rt : rightSubtree) { // and every possible right subtree
    				TreeNode root = new TreeNode(i); // Create a new tree with root value being i
    				root.left = lt; 
    				root.right = rt;
    				result.add(root); // Add this tree to list of all trees
    			}
    		}
    	}

    	return result;
    }
}
