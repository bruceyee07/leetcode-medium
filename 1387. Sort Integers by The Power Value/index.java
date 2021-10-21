/**
 * https://leetcode.com/problems/sort-integers-by-the-power-value/
 * self
 */
class Solution {
  public int getKth(int lo, int hi, int k) {
    Queue<int[]> q = new PriorityQueue<>((x, y) -> {
      if (x[1] == y[1]) return x[0] - y[0];
      return x[1] - y[1];
    });
    for (int i = lo; i <= hi; i++) {
      int power = getPower(i);
      q.offer(new int[]{i, power});
    }
    while (k-- > 1) {
      q.poll();
    }
    int[] pair = q.poll();
    return pair[0];
  }

  public int getPower(int n) {
    int cnt = 0;
    while (n != 1) {
      if (n % 2 == 0) {
        n /= 2;
      } else {
        n = 3 * n + 1;
      }
      cnt++;
    }
    return cnt;
  }
}