/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/discuss/14734/Easy-java-O(logn)-solution
 */
class Solution {
  public int[] searchRange(int[] nums, int target) {
    int[] ans = new int[2];
    ans[0] = findFirst(nums, target);
    ans[1] = findLast(nums, target);
    return ans;
  }

  public int findFirst(int[] nums, int target) {
    int lo = 0, hi = nums.length - 1;
    int pos = -1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (nums[mid] >= target) {
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
      if (nums[mid] == target) pos = mid;
    }
    return pos;
  }

  public int findLast(int[] nums, int target) {
    int lo = 0, hi = nums.length - 1;
    int pos = -1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (nums[mid] <= target) {
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
      if (nums[mid] == target) pos = mid;
    }
    return pos;
  }
}