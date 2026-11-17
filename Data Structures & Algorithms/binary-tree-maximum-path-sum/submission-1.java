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

    int bestGlobal = -1001;
    public int maxPathSum(TreeNode root) {
        bestGlobal = root.val;
        dfs(root);
        return bestGlobal;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, dfs(root.left)), right = Math.max(0, dfs(root.right));
        int bestLocal = root.val + Math.max(left, right);
        bestGlobal = Math.max(bestGlobal, Math.max(bestLocal, root.val + left + right));
        return bestLocal;
    }
}
