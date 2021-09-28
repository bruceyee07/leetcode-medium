/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * self
 */
class Solution {
  public int findKthLargest(int[] nums, int k) {
    Queue<Integer> q = new PriorityQueue<>();
    for (int val : nums) {
      q.offer(val);
      if (q.size() > k)
        q.poll();
    }
    return (int)q.peek();
  }
}