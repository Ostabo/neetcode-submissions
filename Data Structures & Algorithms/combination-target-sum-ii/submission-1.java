class Solution {

    List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new LinkedList();
        Arrays.sort(candidates);
        dfs(candidates, target, new LinkedList(), 0);
        return res;
    }

    private void dfs(int[] candidates, int target, List<Integer> took, int j) {
        if (target == 0) {
            res.add(took);
            return;
        }
        if (target < 0) return;

        for (int i = j; i < candidates.length; i++) {
            int c = candidates[i];
            if (c < 0 || (i > j && candidates[i] == candidates[i - 1])) continue;
            candidates[i] = -c;
            List<Integer> next = new LinkedList();
            next.addAll(took);
            next.add(c);
            dfs(candidates, target - c, next, i + 1);
            candidates[i] = c;
        }
    }
}
