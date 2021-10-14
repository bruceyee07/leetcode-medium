/**
 * https://leetcode.com/problems/coin-change/
 * https://leetcode.com/problems/coin-change/discuss/77368/*Java*-Both-iterative-and-recursive-solutions-with-explanations
 */
class Solution {
  public int coinChange(int[] coins, int amount) {
    if (amount == 0) return 0;
    return helper(coins, amount, new int[amount]);
  }

  public int helper(int[] coins, int amount, int[] dp) {
    if (amount < 0) return -1;
    if (amount == 0) return 0;
    if (dp[amount - 1] != 0) return dp[amount - 1];
    int count = Integer.MAX_VALUE;
    for (int coin : coins) {
      int ans = helper(coins, amount - coin, dp);
      if (ans >= 0 && ans < count)
        count = 1 + ans; 
    }
    dp[amount - 1] = count == Integer.MAX_VALUE ? -1 : count;
    return dp[amount - 1];
  }
}