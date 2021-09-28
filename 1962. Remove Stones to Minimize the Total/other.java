/**
 * https://leetcode.com/problems/remove-stones-to-minimize-the-total/
 * https://leetcode.com/problems/remove-stones-to-minimize-the-total/discuss/1390254/JavaC%2B%2BPython-Heap-Solution-O(klogn)
 */
class Solution {
  public int minStoneSum(int[] piles, int k) {
    Queue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
    int ans = 0;
    for (int val : piles) {
      q.offer(val);
      ans += val;
    }
    while (k-- > 0) {
      int max = q.poll();
      q.offer(max - max / 2);
      ans -= max / 2;
    }
    return ans;
  }
}
