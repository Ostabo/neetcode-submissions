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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return List.of();
        List<List<Integer>> res = new LinkedList();
        Queue<TreeNode> q = new LinkedList();
        Queue<Integer> ql = new LinkedList();

        q.add(root);
        ql.add(0);
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            Integer nLevel = ql.poll();
            if (n == null) continue;
            q.add(n.left);
            ql.add(nLevel + 1);
            q.add(n.right);
            ql.add(nLevel + 1);
            if (nLevel >= res.size()) {
                res.add(new LinkedList());
            }
            res.get(nLevel).add(n.val);
        }

        return res;
    }
}
