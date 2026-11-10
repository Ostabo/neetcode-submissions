class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l1 = 0;
        int r1 = matrix.length - 1;
        while (l1 < r1) {
            int m1 = l1 + (r1 - l1 + 1) / 2;
            int cur = matrix[m1][0];
            if (cur <= target) {
                l1 = m1;
            } else {
                r1 = m1 - 1;
            }
        }

        int[] row = matrix[l1];
        int l2 = 0;
        int r2 = row.length - 1;
        while (l2 < r2) {
            int m2 = l2 + (r2 - l2 + 1) / 2;
            int cur = row[m2];
            if (cur <= target) {
                l2 = m2;
            } else {
                r2 = m2 - 1;
            }
        }
        return row[l2] == target;
    }
}
