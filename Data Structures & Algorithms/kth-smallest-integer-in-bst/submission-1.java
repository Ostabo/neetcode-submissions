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

    List<Integer> ks = new LinkedList();

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return ks.get(k - 1);
    }

    private void dfs(TreeNode n, int k) {
        if (ks.size() >= k) return;

        if (n.left != null) {
            dfs(n.left, k);
        }
        ks.add(n.val);
        if (n.right != null) {
            dfs(n.right, k);
        }
    }
}
