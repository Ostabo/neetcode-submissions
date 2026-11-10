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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode n, int pathMax) {
        if (n == null) return 0;
        if (pathMax <= n.val) {
            return dfs(n.left, n.val) + dfs(n.right, n.val) + 1;
        }   
        return dfs(n.left, pathMax) + dfs(n.right, pathMax);
    }
}
