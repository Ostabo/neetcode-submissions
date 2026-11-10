class Solution {
    int[][] grid;

    public void islandsAndTreasure(int[][] grid) {
        this.grid = grid;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    dfs(i + 1, j, 1);
                    dfs(i - 1, j, 1);
                    dfs(i, j + 1, 1);
                    dfs(i, j - 1, 1);
                }
            }
        }        
    }

    private void dfs(int x, int y, int level) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length) {
            return;
        }
        int cell = grid[x][y];
        if (cell == -1 || level >= cell) return;
        grid[x][y] = level;
        level++;
        dfs(x - 1, y, level);
        dfs(x + 1, y, level);
        dfs(x, y - 1, level);
        dfs(x, y + 1, level);
    }
}
