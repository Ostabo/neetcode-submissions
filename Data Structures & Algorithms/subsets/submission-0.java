class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new LinkedList();
        subsets.add(List.of());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> copy = new ArrayList(subsets);
            for (List<Integer> cur : copy) {
                List<Integer> n = new LinkedList(cur);
                n.add(nums[i]);
                subsets.add(n);
            }
        }
        return subsets;
    }
}
