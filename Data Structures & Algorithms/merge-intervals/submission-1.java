class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> {
            int d1 = i1[0] - i2[0];
            if (d1 == 0) return i1[1] - i2[1];
            return d1;
        });

        int reducedBy = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] i1 = intervals[i - 1];
            int[] i2 = intervals[i];
            if (i1[1] >= i2[0]) {
                reducedBy++;
                intervals[i] = new int[]{i1[0], Math.max(i1[1], i2[1])};
                intervals[i - 1] = new int[]{-1,-1};
            }
        }

        int[][] res = new int[intervals.length - reducedBy][2];
        int diff = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] == -1) {
                diff++;
                continue;
            }
            res[i - diff] = intervals[i];
        }
        return res;
    }
}
