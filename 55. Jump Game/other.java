/**
 * https://leetcode.com/problems/jump-game/
 * https://leetcode.com/problems/jump-game/discuss/20923/Java-Solution-easy-to-understand sohammehta
 * greedy solution
 */
class Solution {
  public boolean canJump(int[] nums) {
    int farest = 0; // tells the maximum index we can reach so far.
    for (int i = 0; i < nums.length; i++) {
      if (i > farest) return false;
      farest = Math.max(farest, i + nums[i]);
    }
    return true;
  }
}