class Solution {
    List<String> res = new LinkedList();

    public List<String> letterCombinations(String digits) {
        char[] chars = digits.toCharArray();
        dfs(chars, 0, digits.length(), "");
        return res;
    }

    private void dfs(char[] chars, int i, int l, String cur) {
        if (cur.length() >= l) {
            if (!cur.isEmpty())
                res.add(cur);
            return;
        }

        char c = chars[i];
        List<String> options = List.of();
        switch (c) {
            case '2':
                options = List.of("a", "b", "c");
                break;
            case '3':
                options = List.of("d", "e", "f");
                break;
            case '4':
                options = List.of("g", "h", "i");
                break;
            case '5':
                options = List.of("j", "k", "l");
                break;
            case '6':
                options = List.of("m", "n", "o");
                break;
            case '7':
                options = List.of("p", "q", "r", "s");
                break;
            case '8':
                options = List.of("t", "u", "v");
                break;
            case '9':
                options = List.of("w", "x", "y", "z");
                break;
        }

        for (String option : options) {
            dfs(chars, i + 1, l, cur + option);
        }
        
    }

}
