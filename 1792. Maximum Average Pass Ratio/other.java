/**
 * https://leetcode.com/problems/maximum-average-pass-ratio/
 * https://leetcode.com/problems/maximum-average-pass-ratio/discuss/1108263/PythonJava-Max-Heap-Clean-and-Concise
 */
class Solution {
  public double maxAverageRatio(int[][] classes, int extraStudents) {
    PriorityQueue<double[]> q = new PriorityQueue<double[]>(Comparator.comparingDouble(p -> -p[0]));
    for (int[] c : classes) {
      double pass = c[0], total = c[1];
      q.offer(new double[]{profit(pass, total), pass, total});
    }
    while (extraStudents-- > 0) {
      double[] top = q.poll();
      double pass = top[1], total = top[2];
      q.offer(new double[]{profit(pass + 1, total + 1), pass + 1, total + 1});
    }
    double ans = 0.0d;
    while (!q.isEmpty()) {
      double[] top = q.poll();
      double pass = top[1], total = top[2];
      ans += pass / total;
    }
    return ans / classes.length;
  }

  public double profit (double a, double b) {
    return (a + 1) / (b + 1) - a / b;
  }
}