/**
 * https://leetcode.com/problems/jump-game/
 * self
 */
class Solution {
  public boolean canJump(int[] nums) {
    if (nums.length == 1) return true;
    int[] dp = new int[nums.length - 1];
    for (int i = 0; i < dp.length; i++) {
      dp[i] = nums.length - 1 - i;
    }
    if (nums[0] >= dp[0]) return true;
    for (int i = 1; i < dp.length; i++) {
      if (nums[i] >= dp[i] && nums[i - 1] > 0) return true;
    }
    return false;
  }
}