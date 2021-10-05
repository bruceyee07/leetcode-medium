/**
 * https://leetcode.com/problems/next-greater-element-ii/
 * https://leetcode.com/problems/next-greater-element-ii/solution/
 */
class Solution {
  public int[] nextGreaterElements(int[] nums) {
    int n = nums.length;
    int[] ans = new int[n];
    Stack<Integer> stack = new Stack<>();
    for (int i = 2 * n - 1; i >= 0; i--) {
      while (!stack.isEmpty() && nums[stack.peek()] <= nums[i % n]) {
        stack.pop();
      }
      ans[i % n] = stack.isEmpty() ? -1 : nums[stack.peek()];
      stack.push(i % n);
    }
    return ans;
  }
}