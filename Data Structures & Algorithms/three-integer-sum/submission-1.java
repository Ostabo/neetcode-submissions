class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList();
        Set<Integer> seen = new HashSet();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (seen.contains(nums[i])) continue;
            seen.add(nums[i]);

            int s = i + 1;
            int e = nums.length - 1;
            int target = -1 * nums[i];
            while (s < e) {
                int sum = nums[s] + nums[e];
                if (sum == target) {
                    res.add(List.of(nums[i], nums[s], nums[e]));
                } 
                if (sum <= target) {
                    s++;
                    while (s < nums.length && nums[s] == nums[s - 1]) s++;
                } else {
                    e--;
                    while (e >= 0 && nums[e] == nums[e + 1]) e--;
                }
            }
        }
        return res;
    }
}
