class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i + 1, j, 1});
                    q.offer(new int[]{i - 1, j, 1});
                    q.offer(new int[]{i, j + 1, 1});
                    q.offer(new int[]{i, j - 1, 1});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cords = q.poll();
            int x = cords[0];
            int y = cords[1];
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length) {
                continue;
            }
            int cur = cords[2];
            int cell = grid[x][y];
            if (cell != 1) continue;
            grid[x][y] = -cur;
            cur++;
            q.offer(new int[]{x + 1, y, cur});
            q.offer(new int[]{x - 1, y, cur});
            q.offer(new int[]{x, y + 1, cur});
            q.offer(new int[]{x, y - 1, cur});
        }


        int min = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int c = grid[i][j];
                if (c == 1) return -1;
                min = Math.min(c, min);
            }
        }

        return min * -1;
    }
}
