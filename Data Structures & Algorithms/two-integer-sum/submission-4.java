class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (seen.containsKey(key)) {
                int j = seen.get(key);
                if (i != j)
                    return new int[]{j, i};
            }

            seen.put(nums[i], i);
        }
        throw new IllegalStateException();
    }
}
