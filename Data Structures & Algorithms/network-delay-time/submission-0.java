class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> g = new HashMap();

        Map<Integer, Integer> dist = new HashMap();

        for (int i = 1; i <= n; i++) {
            g.put(i, new LinkedList());
            dist.put(i, Integer.MAX_VALUE);
        }

        for (int[] uvt : times) {
            g.get(uvt[0]).add(new int[]{uvt[1], uvt[2]});
        }

        dist.put(k, 0);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );
        pq.add(new int[]{k, 0});

        while(!pq.isEmpty()) {
            int[] nt = pq.poll();

            if (dist.get(nt[0]) < nt[1]) continue;

            for (int[] next : g.get(nt[0])) {
                int newDist = next[1] + nt[1];
                if (newDist < dist.get(next[0])) {
                    dist.put(next[0], newDist);
                    pq.offer(new int[]{
                        next[0],
                        newDist
                    });
                }
            }
        }

        int max = 0;
        for (int d : dist.values()) {
            if (d == Integer.MAX_VALUE) return -1;
            if (d > max) max = d;
        }

        return max;
    }
}
