/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 * https://leetcode.com/problems/find-the-duplicate-number/solution/
 */
class Solution {
  public int findDuplicate(int[] nums) {
    int duplicate = -1;
    for (int i = 0; i < nums.length; i++) {
      int cur = Math.abs(nums[i]);
      if (nums[cur] < 0) {
        duplicate = cur;
        break;
      }
      nums[cur] *= -1;
    }
    
    return duplicate;
  }
}