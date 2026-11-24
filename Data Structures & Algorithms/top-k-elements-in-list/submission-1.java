class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[1]-a[1]
        );

        Map<Integer, Integer> counts = new HashMap();

        for (int n : nums) {
            counts.put(n, counts.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> e : counts.entrySet()) {
            int key = e.getKey();
            int v = e.getValue();
            pq.offer(new int []{key, v});
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[0];
        }

        return res;
    }
}
