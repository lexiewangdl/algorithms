package august24;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    // My solution, runtime 2ms beats 34.56%, memory beats 97.18%
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) { return result; }

        Queue<TreeNode> q = new ArrayDeque<>();
        List<Integer> vals = new ArrayList<>();
        TreeNode dummy = new TreeNode();
        q.add(root);
        q.add(dummy);

        while (!q.isEmpty()) {
            TreeNode curr = q.remove();
            if (curr.equals(dummy)) {
                // If we have reached end of level, means than all children of previous level have been queued, now we
                // can add dummy
                if (!q.isEmpty()) { q.add(dummy); }  // if q is empty, we have reached end of the tree
                result.add(vals); // new level, add previous list to result
                vals = new ArrayList<Integer>();  // create new ArrayList
            } else {
                vals.add(curr.val);
                if (curr.left != null) { q.add(curr.left); }
                if (curr.right != null) { q.add(curr.right); }
            }
        }

        return result;
    }
}
