/**
 * https://leetcode.com/problems/container-with-most-water/
 * self
 * Time Limit Exceeded
 */
class Solution {
  public int maxArea(int[] height) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < height.length - 1; i++) {
      for (int j = i + 1; j < height.length; j++) {
        max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
      }
    }
    return max;
  }
}