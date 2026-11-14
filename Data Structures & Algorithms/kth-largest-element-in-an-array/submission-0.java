class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int ind = 0;
        for (int n:nums) pq.offer(new int[]{ind++, n});

        for (int i =0; i<k-1;i++) {
            pq.poll();
        }
        return pq.poll()[1];
    }
}
