/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 * self
 */
class Solution {
  public int[][] kClosest(int[][] points, int k) {
    int[][] ans = new int[k][2];
    PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[0] * b[0] + b[1] * b[1] - a[0] * a[0] - a[1] * a[1]);
    for (int[] point : points) {
      q.offer(point);
    }
    int remove = points.length - k;
    while (remove-- > 0) {
      q.poll();
    }
    int i = 0;
    while (!q.isEmpty()) {
      ans[i++] = q.poll();
    }
    return ans;
  }
}