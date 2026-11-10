class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> rowSeen = new HashSet();
            Set<Character> colSeen = new HashSet();
            for (int j = 0; j < 9; j++) {
                if (rowSeen.contains(board[i][j]) || colSeen.contains(board[j][i])) {
                    return false;
                }
                if (board[i][j] != '.') {
                    rowSeen.add(board[i][j]);
                }
                if (board[j][i] != '.') {
                    colSeen.add(board[j][i]);
                }
            }
        }
        for (int i = 0; i < 7; i+=3) {
            for (int j = 0; j < 7; j+=3) {
                Set<Character> boxSeen = new HashSet();
                for (int x = i; x < i + 3; x++) {
                    for (int y = j; y < j + 3; y++) {
                        if (boxSeen.contains(board[x][y])) {
                            return false;
                        }
                        if (board[x][y] != '.') {
                            boxSeen.add(board[x][y]);
                        }
                    }
                }
            }
        }
        return true;
    }
}
