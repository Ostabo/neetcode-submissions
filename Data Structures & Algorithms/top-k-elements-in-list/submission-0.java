class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> fm = new HashMap();
        for (int n : nums) {
            if (fm.containsKey(n)) {
                fm.put(n, fm.get(n) + 1);
            } else {
                fm.put(n, 1);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue((a, b) -> {
            return fm.getOrDefault(b, 0) - fm.getOrDefault(a, 0);
        });
        for (int n : fm.keySet()) {
            pq.offer(n);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }

        return res;
    }
}
