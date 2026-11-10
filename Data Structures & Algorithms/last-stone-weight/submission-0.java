class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue(Comparator.naturalOrder().reversed());
        for (int stone : stones) {
            pq.offer(stone);
        }
        while (pq.size() >= 2) {
            int s1 = pq.poll();
            int s2 = pq.poll();
            
            int diff = Math.abs(s1 - s2);
            if (diff != 0) {
                pq.offer(diff);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
