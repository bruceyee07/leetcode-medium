/**
 * https://leetcode.com/problems/remove-stones-to-minimize-the-total/
 * self
 */
class Solution {
  public int minStoneSum(int[] piles, int k) {
    Queue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
    for (int val : piles) {
      q.offer(val);
    }
    for (int i = 0; i < k; i++) {
      int max = q.poll();
      q.offer(max - (int)Math.floor(max / 2));
    }
    int count = 0;
    for (Integer p : q) {
      count += (int)p;
    }
    return count;
  }
}
