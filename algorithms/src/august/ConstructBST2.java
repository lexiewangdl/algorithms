package august;

import java.util.HashMap;
import java.util.Map;

public class ConstructBST2 {
	
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
	
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    
    	int inLen = inorder.length;
    	int postLen = postorder.length;
    	
    	Map<Integer, Integer> inMap = new HashMap<>(inLen);
    	for (int i = 0; i < inLen; i++) {
    		inMap.put(inorder[i], i);
    	}
    	
    	return build(postorder, inMap, 0, postLen-1, 0, inLen-1);
    }
    
    public TreeNode build(int[] postorder, Map<Integer, Integer> inMap, int postL, int postR, int inL, int inR) {
    	
    	if (postL > postR || inL > inR) return null;
    	
    	int rootVal = postorder[postR];
    	TreeNode root = new TreeNode(rootVal);
    	int pIdx = inMap.get(rootVal);
    	
    	root.left = build(postorder, inMap, postL, postL+pIdx-inL-1, inL, pIdx-1);
    	root.right = build(postorder, inMap, postL+pIdx-inL, postR-1, pIdx+1, inR);
    	
    	return root;
    }

}
