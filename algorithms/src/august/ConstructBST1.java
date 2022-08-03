package august;

import java.util.HashMap;
import java.util.Map;

public class ConstructBST1 {
	
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
	
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	
    	int preLen = preorder.length;
    	int inLen = inorder.length;
    	
    	// Build a hash map to store value of node as key, and index of node in
    	// in-order array as values for searching purposes
    	Map<Integer, Integer> inMap = new HashMap<>(inLen);
    	for (int i = 0; i < inLen; i++) {
    		inMap.put(inorder[i], i);
    	}
    	
    	return build(preorder, inMap, 0, preLen-1, 0, inLen-1);
    	
    }

    public TreeNode build(int[] preorder, Map<Integer, Integer> inMap, int preL, int preR, int inL, int inR) {
    	
    	if (preL > preR || inL > inR) {
    		return null;
    	}
    	
    	int rootVal = preorder[preL]; // The left-most element of the pre-order array is the root for the current subtree
    	TreeNode root = new TreeNode(rootVal); // Create this node (which is root of subtree)
    	int pIndex = inMap.get(rootVal); // Get the index of root node in in-order array
    	
    	root.left = build(preorder, inMap, preL+1, pIndex-inL+preL, inL, pIndex-1);
    	root.right = build(preorder, inMap, pIndex-inL+preL+1, preR, pIndex+1, inR);
    	
    	return root;
    }
}
