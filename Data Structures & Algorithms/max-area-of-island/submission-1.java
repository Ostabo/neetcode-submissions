class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                max = Math.max(dfs(grid, i, j), max);
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length) {
            return 0;
        }
        int cur = grid[x][y];
        if (cur == 0) {
            return 0;
        }

        grid[x][y] = 0;
        return 1 + dfs(grid, x + 1, y) + dfs(grid, x, y + 1) + dfs(grid, x - 1, y) +  + dfs(grid, x, y - 1);
    }
}
