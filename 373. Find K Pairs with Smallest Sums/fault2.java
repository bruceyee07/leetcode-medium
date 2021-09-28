/**
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 * self
 * time limit exceeded
 */
public class Pair {
  public int x;
  public int y;
  public Pair(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
class Solution {
  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    Queue<Pair> q = new PriorityQueue<>((a, b) -> (b.x + b.y) - (a.x + a.y));
    for (int i = 0; i < nums1.length; i++) {
      for (int j = 0; j < nums2.length; j++) {
        q.offer(new Pair(nums1[i], nums2[j]));
        if (q.size() > k) {
          q.poll();
        }
      }
    }
    List<List<Integer>> ans = new ArrayList<>();
    while (k-- > 0) {
      if (q.isEmpty()) {
        break;
      }
      Pair entry = q.poll();
      List<Integer> item = new ArrayList<>();
      item.add(Integer.valueOf(entry.x));
      item.add(Integer.valueOf(entry.y));
      ans.add(item);
    }
    return ans;
  }
}