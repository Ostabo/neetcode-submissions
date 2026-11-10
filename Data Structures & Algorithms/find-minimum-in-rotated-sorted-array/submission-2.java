class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r - 1) {
            int m = (r + l) / 2;
            if (nums[l] > nums[m]) {
                r = m;
            } else if (nums[l] > nums[r]) {
                l = m;  
            } else {
                r = m - 1;
            }
        }
        return Math.min(nums[l], nums[r]);
    }
}
