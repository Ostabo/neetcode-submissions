class Solution {

    int[] memo;

    public int numDecodings(String s) {
        int[] chars = new int[s.length()];
        memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        char[] ca = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = Character.getNumericValue(ca[i]);
        }
        dfs(chars, 0);
        return memo[0];
    }

    private void dfs(int[] chars, int i) {
        if (memo[i] != -1) return;
        if (i >= chars.length) {
            memo[i] = 1;
            memo[i - 1] = chars[i - 1] == 0 ? 0 : 1;
            return;
        }

        if (chars[i] == 0) {
            memo[i] = 0;
            return;
        }

        dfs(chars, i+1);
        if (i < chars.length - 1 && (chars[i] < 2 || (chars[i] < 3 && chars[i + 1] < 7))) {
            dfs(chars, i+2);
            memo[i] = memo[i + 2] + memo[i + 1];
        } else {
            memo[i] = memo[i + 1];
        }
    }
}
