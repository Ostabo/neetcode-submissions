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
    Map<Integer, Integer> visited = new HashMap();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return new LinkedList(visited.values());
    }
    private void dfs(TreeNode node, int level) {
        if (node == null) return;
        if (!visited.containsKey(level)) {
            visited.put(level, node.val);
        }
        dfs(node.right, level + 1);
        dfs(node.left, level + 1);
    }
}
