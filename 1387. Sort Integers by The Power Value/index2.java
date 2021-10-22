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
    return q.poll()[0];
  }

  public int getPower(int n) {
    if (n == 1) return 0;
    Map<Integer, Integer> m = new HashMap<>();
    if (m.get(n) != null) return m.get(n);
    if ((n & 1) == 0) {
      m.put(n, getPower(n / 2) + 1);
    } else {
      m.put(n, getPower(3 * n + 1) + 1);
    }
    return m.get(n);
  }
}