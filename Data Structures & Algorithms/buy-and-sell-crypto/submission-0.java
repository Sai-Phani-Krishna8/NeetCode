class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int left = 0;
        for(int right=1; right<prices.length; right++) {
            if(prices[right] < prices[right-1] && prices[right] < prices[left]) {
                left = right;
            } else {
                profit = Math.max(profit, prices[right] - prices[left]);
            }
        }
        return profit;
    }
}
