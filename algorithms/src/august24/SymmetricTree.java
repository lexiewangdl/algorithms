package august24;

import august24.TreeNode;

public class SymmetricTree {

    private boolean isMirror(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        }
        if (l == null || r == null) {
            return false;
        }
        return (l.val == r.val && isMirror(l.left, r.right) && isMirror(l.right, r.left));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }
}
