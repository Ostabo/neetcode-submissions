class WordDictionary {

    class Node {
        Character val;
        Map<Character, Node> children;
        public Node(Character val, Map<Character, Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    Node root;

    public WordDictionary() {
        root = new Node('@', new HashMap());
    }

    public void addWord(String word) {
        Node it = root;
        char[] chars = word.toCharArray();
        int i = 0;
        while (i < chars.length && it.children.containsKey(chars[i])) it = it.children.get(chars[i++]);
        while (i < chars.length) {
            Node nn = new Node(chars[i], new HashMap());
            it.children.put(chars[i], nn);
            it = nn;
            i++;
        }
        it.children.putIfAbsent('@', new Node('@', new HashMap()));
    }

    public boolean search(String word) {
        Node it = root;
        char[] chars = word.toCharArray();
        int i = 0;
        return dfs(chars, i, it);
    }

    private boolean dfs(char[] chars, int i, Node n) {
        if (i >= chars.length) return n.children.containsKey('@');

        while (i < chars.length && chars[i] != '.' && n.children.containsKey(chars[i])) 
            n = n.children.get(chars[i++]);

        if (i >= chars.length) return n.children.containsKey('@');
        if (chars[i] == '.') {
            boolean res = false;
            for (Node next : n.children.values()) {
                res = res || dfs(chars, i + 1, next);
                if (res) return true;
            }
        }
        return false;
    }
}
