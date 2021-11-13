/**
 * https://leetcode.com/problems/sort-colors/
 * https://leetcode.com/problems/sort-colors/discuss/26481/Python-O(n)-1-pass-in-place-solution-with-explanation
 */
class Solution {
  public void sortColors(int[] nums) {
    int r = 0, w = 0, b = nums.length - 1;
    while (w <= b) {
      if (nums[w] == 0) {
        swap(nums, r, w);
        r++;
        w++;
      } else if (nums[w] == 1) {
        w++;
      } else {
        swap(nums, w, b);
        b--;
      }
    }
  }

  public void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}