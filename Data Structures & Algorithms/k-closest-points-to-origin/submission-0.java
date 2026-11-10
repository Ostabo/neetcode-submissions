class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (c1, c2) -> {
                int x1 = c1[0];
                int y1 = c1[1];
                int x2 = c2[0];
                int y2 = c2[1];

                double ed1 = Math.sqrt(x1*x1 + y1*y1);
                double ed2 = Math.sqrt(x2*x2 + y2*y2);

                return ed2 - ed1 <= 0 ? 1 : -1;
            }
        );
        for (int[] cord : points) {
            pq.add(cord);
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}
