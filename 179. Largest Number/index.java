/**
 * https://leetcode.com/problems/largest-number/
 * self
 */
class Solution {
  public String largestNumber(int[] nums) {
    StringBuilder ans = new StringBuilder();
    Queue<Integer> q = new PriorityQueue<>((a, b) -> {
      String sa = String.valueOf(a);
      String sb = String.valueOf(b);
      return (sb + sa).compareTo(sa + sb);
    });
    for (int val : nums) {
      q.offer(val);
    }
    if (q.peek() == 0) {
      return "0";
    }
    while (!q.isEmpty()) {
      ans.append(String.valueOf(q.poll()));
    }
    return ans.toString();
  }
}
