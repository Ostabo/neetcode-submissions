class Solution {

    class Combination {
        public int sum = 0;
        public List<Integer> l = new LinkedList();
        public Stack<Integer> options = new Stack();

        public Combination copy() {
            Combination c = new Combination();
            c.l = new LinkedList(l);
            c.options = (Stack<Integer>)options.clone();
            c.sum = sum;
            return c;
        }
    }
    
    List<List<Integer>> res = new LinkedList();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Combination sc = new Combination();
        for (int n : nums) {
            sc.options.add(n);
        }
        dfs(sc, target);
        return res;
    }

    private void dfs(Combination c, int target) {
        if (c.sum == target) {
            res.add(c.l);
            return;
        }
        if (c.sum > target) return;

        while (!c.options.isEmpty()) {
            int cur = c.options.peek();
            Combination newC = c.copy();
            newC.sum += cur;
            newC.l.add(cur);
            dfs(newC, target);
            c.options.pop();
        }
    }
}
