class Solution {

    class P {
        char c;
        int p;
        public P(char c, int p) {
            this.c = c;
            this.p = p;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        if (tasks.length <= 0) return 0;
        Map<Character, Integer> m = new HashMap();
        PriorityQueue<P> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.p, b.p)
        );

        for (int i = 0; i < tasks.length; i++) {
            char key = tasks[i];
            if (m.containsKey(key)) {
                m.put(key, m.get(key) + n + 1);
            } else {
                m.put(key, 0);
            }

            pq.add(new P(key, m.get(key)));
        }

        int res = 0;
        while (!pq.isEmpty()) {
            P cur = pq.poll();
            if (res < cur.p) res = cur.p;
            res++;
        }

        return res;
    }
}
