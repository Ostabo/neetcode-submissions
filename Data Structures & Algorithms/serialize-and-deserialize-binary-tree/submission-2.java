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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null) {
                sb.append("null;");
                continue;
            }
            sb.append(cur.val + ";");
            q.add(cur.left);
            q.add(cur.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(";");
        TreeNode[] nodes = new TreeNode[split.length];
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("null")) {
                nodes[i] = null;
            } else {
                nodes[i] = new TreeNode(Integer.valueOf(split[i]));
            }
        }

        int seenNulls = 0;
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == null) {
                seenNulls++;
                continue;
            }

            TreeNode cur = nodes[i];
            int j = (i - seenNulls) * 2;
            if (j + 1 < nodes.length)
                cur.left = nodes[j + 1];
            if (j + 2 < nodes.length)
                cur.right = nodes[j + 2];
        }

        return nodes[0];
    }
}
