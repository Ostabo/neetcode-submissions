class Solution {
    public boolean exist(char[][] board, String word) {
        if (word.length() <= 0) return true;
        if (board.length <= 0) return false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, i, j, word)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int r, int c, String remainingWord) {
        if (remainingWord.length() <= 0) return true;
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) return false;
        if (board[r][c] != remainingWord.charAt(0)) return false;
        
        char temp = board[r][c];
        board[r][c] = '#';
        String newRemainingWord = remainingWord.substring(1);
        boolean found = dfs(board, r - 1, c, newRemainingWord) || 
                        dfs(board, r + 1, c, newRemainingWord) ||
                        dfs(board, r, c - 1, newRemainingWord) ||
                        dfs(board, r, c + 1, newRemainingWord);
        board[r][c] = temp;
        return found;
    }
}