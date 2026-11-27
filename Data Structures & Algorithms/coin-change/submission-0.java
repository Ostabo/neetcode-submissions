class Solution {
    int res = -1;
    public int coinChange(int[] coins, int amount) {
        dfs(coins, 0, amount, 0);
        return res;
    }

    private void dfs(int[] coins, int i, int amount, int cur) {
        if (amount == 0) {
            res = res == -1 ? cur : Math.min(res, cur);
            return;
        }
        if (amount < 0 || i > coins.length - 1) return;

        dfs(coins, i, amount - coins[i], cur + 1);
        dfs(coins, i + 1, amount, cur);
    }
}
