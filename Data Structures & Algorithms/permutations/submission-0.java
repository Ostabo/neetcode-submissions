class Solution {

    List<List<Integer>> res = new LinkedList();

    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> options = new HashSet();
        for (int n : nums) {
            options.add(n);
        }
        dfs(new LinkedList(), options);

        return res; 
    }

    private void dfs(List<Integer> cur, Set<Integer> options) {
        if (options.size() <= 0) {
            res.add(cur);
            return;
        }

        for (int option : options) {
            Set<Integer> newOptions = new HashSet();
            newOptions.addAll(options);
            newOptions.remove(option);
            List<Integer> newCur = new LinkedList();
            newCur.addAll(cur);
            newCur.add(option);
            dfs(newCur, newOptions);
        }
    }
}
