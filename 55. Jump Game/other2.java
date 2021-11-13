/**
 * https://leetcode.com/problems/jump-game/
 * https://leetcode.com/problems/jump-game/discuss/20923/Java-Solution-easy-to-understand sohammehta
 * dynamic programming
 */
class Solution {
  public boolean canJump(int[] nums) {
    int n = nums.length;
    boolean[] dp = new boolean[n];
    dp[n - 1] = true;
    for (int i = n - 2; i >= 0; i--) {
      for (int j = 0; j <= nums[i] && i + j < n; j++) {
        if (dp[i + j]) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[0];
  }
}