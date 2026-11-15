class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // (x * speed + position) - 10 <= 0
        // x = (10 - position) / speed
        int[][] ps = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            ps[i] = new int[]{position[i], speed[i]};
        }
        Arrays.sort(ps, (a, b) -> a[0] - b[0]);

        double[] ticks = new double[ps.length];
        for (int i = 0; i < ps.length; i++) {
            ticks[i] = (double)(target - ps[i][0]) / ps[i][1];
        }
        int fleets = ticks.length;
        for (int i = ticks.length - 1; i > 0; i--) {
            if (ticks[i] >= ticks[i - 1]) {
                ticks[i - 1] = ticks[i];
                fleets--;
            }
        }

        return fleets;
    }
}
