class KthLargest {
    int k;
    PriorityQueue<Integer> nums;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = new PriorityQueue();
        for (int num : nums) {
            this.nums.offer(num);
        }
        while (this.nums.size() > k) this.nums.poll();
    }
    
    public int add(int val) {
        this.nums.offer(val);
        while (this.nums.size() > k) this.nums.poll();
        return this.nums.peek();
    }
}
