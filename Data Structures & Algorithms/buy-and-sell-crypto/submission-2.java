class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 1;

        int maxPrice = 0;
        while (r < prices.length) {
            int leftPrice = prices[l];
            int rightPrice = prices[r];

            if (leftPrice > rightPrice) {
                l = r;
            } else {
                r++;
                maxPrice = Math.max(maxPrice, rightPrice - leftPrice);
            }
        }
        return maxPrice;
    }
}
