/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solution/
 */
class Solution {
  public int maxProfit(int[] prices) {
    int valley = prices[0], peak = prices[0];
    int max = 0;
    int i = 0;
    while (i < prices.length - 1) {
      while (i < prices.length - 1 && prices[i] >= prices[i + 1]) i++;
      valley = prices[i];
      while (i < prices.length - 1 && prices[i] <= prices[i + 1]) i++;
      peak = prices[i];
      max += peak - valley;
    }
    return max;
  }
}