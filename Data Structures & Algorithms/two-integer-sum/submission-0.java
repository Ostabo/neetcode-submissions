class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int[] res = {i, j};
                    return res;
                }
            }
        }
        throw new IllegalStateException("Not possible by problem definition");
    }
}
