class Solution {

    public void solve(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            dfs(i, 0, board);
            dfs(i, board[0].length - 1, board);
        }

        if (board.length <= 0) return;
        for (int i = 0; i < board[0].length; i++) {
            dfs(0, i, board);
            dfs(board.length - 1, i, board);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = board[i][j] == 'O' ? 'X' : (board[i][j] == 'W' ? 'O' : 'X');
            }
        }

    }

    private void dfs(int x, int y, char[][] board) {
        if (x < 0 || y < 0 || 
        x >= board.length || 
        y >= board[x].length || 
        board[x][y] == 'X' || 
        board[x][y] == 'W') {
            return;
        }
        board[x][y] = 'W';
        dfs(x + 1, y, board);
        dfs(x - 1, y, board);
        dfs(x, y + 1, board);
        dfs(x, y - 1, board);
    }
}
