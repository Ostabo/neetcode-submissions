class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] steps = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            steps[i] = new int[grid[i].length];
        }
        int[][] visited = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            visited[i] = new int[grid[i].length];
        }
        for (int i = 0; i < steps.length; i++) {
            for (int j = 0; j < steps[i].length; j++) {
                visited[i][j] = grid[i][j];
            }
        }
    
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    dfs(grid, steps, visited, i + 1, j, 1);
                    dfs(grid, steps, visited, i - 1, j, 1);
                    dfs(grid, steps, visited, i, j + 1, 1);
                    dfs(grid, steps, visited, i, j - 1, 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < steps.length; i++) {
            for (int j = 0; j < steps[i].length; j++) {
                max = Math.max(steps[i][j], max);
                if (visited[i][j] == 1) return -1;
            }
        }
        return max;
    }

    private void dfs(int[][] grid, int[][] distances, int[][] visited, int x, int y, int step) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length) return;
        int cell = grid[x][y];
        int distance = distances[x][y];
        if (cell == 2 || cell == 0 || (distance != 0 && distance <= step)) return;
        distances[x][y] = step;
        visited[x][y] = 2;
        step++;
        dfs(grid, distances, visited, x + 1, y, step);
        dfs(grid, distances, visited, x - 1, y, step);
        dfs(grid, distances, visited, x, y + 1, step);
        dfs(grid, distances, visited, x, y - 1, step);
    }
}
