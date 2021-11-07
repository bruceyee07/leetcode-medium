/**
 * https://leetcode.com/problems/rotate-array/
 * self
 */
class Solution {
  public void rotate(int[] nums, int k) {
    int n = nums.length;
    k = k % n;
    int[] front = Arrays.copyOfRange(nums, n - k, n);
    int[] end = Arrays.copyOfRange(nums, 0, n - k);
    int[] concatedArr = IntStream.concat(Arrays.stream(front), Arrays.stream(end)).toArray();
    int i = 0;
    for (int val : concatedArr) {
      nums[i++] = val;
    }
  }
}