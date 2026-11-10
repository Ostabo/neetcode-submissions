class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> m = new HashMap();

        for (int[] rq : prerequisites) {
            m.put(rq[1], rq[0]);
        }

        for (int[] rq : prerequisites) {
            int l = rq[0];
            Set<Integer> seen = new HashSet();
            seen.add(rq[1]);

            while (m.containsKey(l)) {
                seen.add(l);
                l = m.get(l);
                if (seen.contains(l)) return false;
            }
        }

        return true;
    }
}
