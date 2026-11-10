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
    public boolean isValidBST(TreeNode root) {
        if (root.left != null && root.val <= root.left.val) return false;
        if (root.right != null && root.val >= root.right.val) return false;
        return dfs(root.left, -Integer.MAX_VALUE, root.val) &&
            dfs(root.right, root.val, Integer.MAX_VALUE);
    }

    private boolean dfs(TreeNode root, int l, int r) {
        if (root == null) return true;
        if (root.val <= l || root.val >= r) return false;
        return dfs(root.left, l, root.val) && dfs(root.right, root.val, r);
    }
}
