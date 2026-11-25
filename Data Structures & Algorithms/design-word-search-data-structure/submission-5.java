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
    if (i == chars.length) return n.children.containsKey('@');

    if (chars[i] == '.') {
        for (Map.Entry<Character, Node> entry : n.children.entrySet()) {
            if (entry.getKey() == '@') continue;

            if (dfs(chars, i + 1, entry.getValue())) return true;
        }
        return false;
    }

    Node next = n.children.get(chars[i]);
    if (next == null) return false;

    return dfs(chars, i + 1, next);
}
}
