class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int max = Arrays.stream(piles).max().getAsInt();
        if (piles.length > h) return max; // this should be forbidden case imo
        while (l < max) {
            int cur = l + ((max-l) / 2);

            long eatCounts = 0;
            for(int i = 0; i < piles.length; i++) {
                eatCounts += (piles[i] + cur - 1) / cur;
                if (eatCounts > h) break;
            }
            if (eatCounts <= h) {
                max = cur;
            } else {
                l = cur + 1;
            }
        }
        return max;
    }
}
