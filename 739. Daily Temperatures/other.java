/**
 * https://leetcode.com/problems/daily-temperatures/
 * https://leetcode.com/problems/daily-temperatures/discuss/109832/Java-Easy-AC-Solution-with-Stack
 */
class Solution {
  public int[] dailyTemperatures(int[] temperatures) {
    Stack<Integer> stack = new Stack<>();
    int[] ans = new int[temperatures.length];
    for (int i = 0; i < ans.length; i++) {
      while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
        int idx = stack.pop();
        ans[idx] = i - idx;
      }
      stack.push(i);
    }
    return ans;
  }
}