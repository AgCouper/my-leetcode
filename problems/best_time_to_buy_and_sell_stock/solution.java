class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxPrice = prices[n - 1];
        int maxProfit = 0;
        for (int i = n - 2; i>= 0; i--) {
            if (prices[i] > maxPrice) {
                maxPrice = prices[i];
            }

            maxProfit = Math.max(maxProfit, maxPrice - prices[i]);
        }
        return maxProfit;
    }
}