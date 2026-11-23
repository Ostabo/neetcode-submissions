class Solution {

    Set<String> res = new HashSet();

    public List<String> generateParenthesis(int n) {
        dfs("", 0, n);

        return res.stream().toList();
    }

    private void dfs(String s, int open, int n) {
        if (Math.abs(open) > n) return;
        if (s.length() >= n * 2) {
            if (open == 0) res.add(s);
            return;
        }

        if (open > 0)
            dfs(s + ")", open - 1, n);
        dfs(s + "(", open + 1, n);
    }
}
