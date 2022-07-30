package july;

import java.util.ArrayList;
import java.util.List;

public class RecoverBinarySearchTree {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {};
		TreeNode(int val) {this.val = val;};
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		};
	}
	
	public void inOrderTraversal(TreeNode root, List<Integer> nums) {
		if (root == null) return;
		inOrderTraversal(root.left, nums);
		nums.add(root.val);
		inOrderTraversal(root.right, nums);
	}
	
    public void recover(TreeNode root, int count, int x, int y) {
        if (root != null) {
            if (root.val == x || root.val == y) {
                root.val = root.val == x ? y : x;
                if (--count == 0) {
                    return;
                }
            }
            recover(root.right, count, x, y);
            recover(root.left, count, x, y);
        }
    }

    public void recoverTree(TreeNode root) {
    	List<Integer> nums = new ArrayList<Integer>();
    	inOrderTraversal(root, nums);
    	
    	int n = nums.size();
    	int idx1 = -1, idx2 = -1;
    	for (int i = 0; i < n-1; ++i) {
    		if(nums.get(i+1) < nums.get(i)) {
    			idx2 = i+1;
    			if (idx1 == -1) {
    				idx1 = i;
    			} else {
    				break;
    			}
    		}
    	}
    	int x = nums.get(idx1), y = nums.get(idx2);
    	
    	recover(root, 2, x, y);
    }

}
