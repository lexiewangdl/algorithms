package august;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PathSumII {

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
	
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    	List<List<Integer>> result = new ArrayList<>();
    	Deque<Integer> path = new LinkedList<Integer>();
    	
    	dfs(root, targetSum, result, path);
    	
    	return result;
    }
    
    public void dfs(TreeNode root, int sum, List<List<Integer>> result, Deque<Integer> path) {
    	if (root == null) return;
    	
    	// Add node to the end of path list
    	path.offerLast(root.val);
    	
    	// Get remaining sum
    	sum -= root.val;
    	
    	// If the node is a leaf node with no child and remaining sum is 0
    	if (root.left == null && root.right == null && sum == 0) {
    		result.add(new ArrayList<Integer>(path));
    	}
    	
    	dfs(root.left, sum, result, path);
    	dfs(root.right, sum, result, path);
    	
    	// Removes last element of deque, which is current node
    	path.pollLast();
    }
}
