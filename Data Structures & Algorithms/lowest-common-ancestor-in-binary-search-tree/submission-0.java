/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    TreeNode res = null;
    TreeNode p, q;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        dfs(root);
        return res;
    }

    private int dfs(TreeNode n) {
        if (res != null) return -102;
        if (n == null) return -101;
        int l = dfs(n.left);
        int r = dfs(n.right);
        if (
            ((l == p.val || r == p.val || n.val == p.val) && (l == q.val || r == q.val || n.val == q.val))
        ) {
            res = n;
            return -103;
        }
        if (n.val == p.val) return p.val;
        else if (n.val == q.val) return q.val;

        return l > -101 ? l : r > -101 ? r : -104;
    }
}
