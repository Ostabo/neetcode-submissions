class Solution {
    public int numIslands(char[][] grid) {
        Set<String> visited = new HashSet();
        int islands = 0;

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                String index = x + ":" + y;
                if (visited.contains(index) || grid[x][y] == '0') {
                    continue;
                }

                islands++;
                dfs(grid, visited, x, y);
            }
        }

        return islands;
    }

    private void dfs(char[][] grid, Set<String> visited, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[x].length) return;
        String index = x + ":" + y;
        if (visited.contains(index)) return;
        visited.add(index);
        if (grid[x][y] == '0') return;
        dfs(grid, visited, x - 1, y);
        dfs(grid, visited, x + 1, y);
        dfs(grid, visited, x, y - 1);
        dfs(grid, visited, x, y + 1);
    }
}
