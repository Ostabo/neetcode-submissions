class Solution {
    public int rob(int[] nums) {
        if (nums.length <= 1) {
            return nums[nums.length - 1];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        
        nums[1] = Math.max(nums[0], nums[1]);
        nums[2] = nums[0] + nums[2];

        int i = 3;
        while (i < nums.length) {
            nums[i] = Math.max(nums[i - 2], nums[i - 3]) + nums[i];
            i++;
        }
        i--;

        return Math.max(nums[i], nums[i - 1]);
    }
}
