class PrefixTree {

    Node root;

    class Node {
        Character c;
        List<Node> children;

        Node(Character c, List<Node> children) {
            this.c = c;
            this.children = children;
        }
    }

    public PrefixTree() {
        root = new Node(null, new LinkedList());
    }

    public void insert(String word) {
        char[] chars = word.toCharArray();
        Node n = root;
        for (int i = 0; i < chars.length; i++) {
            char cur = chars[i];
            int existingInd = -1;
            for (int j = 0; j < n.children.size(); j++) {
                if (n.children.get(j) != null && n.children.get(j).c  == cur) {
                    existingInd = j;
                    break;
                }
            }
            if (existingInd != -1) {
                n = n.children.get(existingInd);
            } else {
                n.children.add(new Node(cur, new LinkedList()));
                n = n.children.getLast();
            }
        }
        n.children.add(null);
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        Node n = root;
        for (int i = 0; i < chars.length; i++) {
            char cur = chars[i];
            int existingInd = -1;
            for (int j = 0; j < n.children.size(); j++) {
                if (n.children.get(j) != null && n.children.get(j).c  == cur) {
                    existingInd = j;
                    break;
                }
            }
            if (existingInd != -1) {
                n = n.children.get(existingInd);
            } else {
                return false;
            }
        }
        return n.children.contains(null);
    }

    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        Node n = root;
        for (int i = 0; i < chars.length; i++) {
            char cur = chars[i];
            int existingInd = -1;
            for (int j = 0; j < n.children.size(); j++) {
                if (n.children.get(j) != null && n.children.get(j).c == cur) {
                    existingInd = j;
                    break;
                }
            }
            if (existingInd != -1) {
                n = n.children.get(existingInd);
            } else {
                return false;
            }
        }
        return true;
    }
}
