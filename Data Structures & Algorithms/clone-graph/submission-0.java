/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    Map<Integer, Node> seen = new HashMap();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node newNode = new Node(node.val);
        seen.put(node.val, newNode);
        for (Node nb : node.neighbors) {
            dfs(newNode, nb);
        }
        return newNode;
    }
    
    private void dfs(Node prev, Node cur) {
        if (seen.containsKey(cur.val)) {
            Node seenNeighbor = seen.get(cur.val);
            prev.neighbors.add(seenNeighbor);
            return;
        }
        Node newCur = new Node(cur.val);
        seen.put(cur.val, newCur);
        prev.neighbors.add(newCur);
        for (Node nb : cur.neighbors) {
            dfs(newCur, nb);
        }
    }
}