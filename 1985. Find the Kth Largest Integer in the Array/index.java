/**
 * https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/
 * self
 */
class Solution {
  public String kthLargestNumber(String[] nums, int k) {
    Queue<String> q = new PriorityQueue<>((a, b) -> {
      if (a.length() == b.length()) {
        for (int i = 0; i < a.length(); i++) {
          if (a.charAt(i) != b.charAt(i))
            return a.charAt(i) - b.charAt(i);
        }
        return -1;
      }
      return a.length() - b.length();
    });
    for (String s : nums) {
      q.offer(s);
      if (q.size() > k) {
        q.poll();
      }
    }
    return q.peek();
  }
}