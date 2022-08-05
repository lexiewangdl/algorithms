package august;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {

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
	
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	
    	List<List<Integer>> result = new ArrayList<>(); 
    	
    	if (root == null) return result;
    	
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	q.offer(root);
    	
    	while (!q.isEmpty()) {
    		List<Integer> curLevel = new ArrayList<Integer>(); // Store values in current level
    		int s = q.size(); // Number nodes in current level
    		for (int i = 0; i < s; i++) {
    			TreeNode n = q.poll(); // Take out node one by one
    			curLevel.add(n.val);
    			
    			TreeNode l = n.left, r = n.right;
    			if (l != null) { q.offer(l); } // If left child node is not null, put it in queue
    			if (r != null) { q.offer(r); }
    		}
    		result.add(0, curLevel); // Add to head of list
    	}

    	return result;
    }
}
