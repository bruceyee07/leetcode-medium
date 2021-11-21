/**
 * https://leetcode.com/problems/maximum-product-subarray/
 * https://leetcode.com/problems/maximum-product-subarray/discuss/48230/Possibly-simplest-solution-with-O(n)-time-complexity
 */
class Solution {
  public int maxProduct(int[] nums) {
    int ans = nums[0];
    for (int i = 1, imax = ans, imin = ans; i < nums.length; i++) {
      if (nums[i] < 0) {
        int temp = imax;
        imax = imin;
        imin = temp;
      }
      imax = Math.max(nums[i], nums[i] * imax);
      imin = Math.min(nums[i], nums[i] * imin);
      ans = Math.max(ans, imax);
    }
    return ans;
  }
}