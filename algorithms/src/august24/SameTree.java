/*
Date: Jul 31 2024
Problem: https://leetcode.com/problems/same-tree/description/
Solution: Runtime beats 100%, memory beats 88%
 */
package august24;

import java.util.ArrayDeque;
import java.util.Queue;
import august24.TreeNode;

public class SameTree {

    // Better solution
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both nodes are null, they are the same
        if (q == null && p == null) { return true; }
        // If one node of the two is null, they are different
        if (q == null || p == null) { return false; }

        // After checking previous 2 conditions, two nodes must be non-null
        // Check if the values are the same and check their left and right children
        return ((q.val == p.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }

//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        if (q == null && p == null) {
//            return true;
//        } else if (q == null || p == null) {
//            return false;
//        }
//
//        Queue<TreeNode> q1 = new ArrayDeque<>();
//        Queue<TreeNode> q2 = new ArrayDeque<>();
//
//        q1.add(p);
//        q2.add(q);
//
//        while (!q1.isEmpty()) {
//            if (q2.isEmpty()) {
//                return false;
//            }
//
//            TreeNode c1 = q1.remove();
//            TreeNode c2 = q2.remove();
//
//            if (c1.val != c2.val) {
//                return false;
//            }
//
//            if ((c1.left == null ^ c2.left == null) || (c1.right == null ^ c2.right == null)) {
//                return false;
//            }
//
//            if (c1.left != null) {
//                q1.add(c1.left);
//                q2.add(c2.left);
//            }
//
//            if (c1.right != null) {
//                q1.add(c1.right);
//                q2.add(c2.right);
//            }
//        }
//
//        return true;
//    }
}
