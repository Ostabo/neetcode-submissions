class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 0) return 0;
        Arrays.sort(nums);
        int longest = 0;
        int cur = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;

            if (nums[i - 1] == nums[i] - 1) {
                cur++;
                if (cur > longest) longest = cur;
            } else {
                cur = 1;
            }
        }
        return Math.max(cur, longest);
    }
}
