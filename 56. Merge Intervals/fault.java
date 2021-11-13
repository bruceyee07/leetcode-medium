/**
 * https://leetcode.com/problems/merge-intervals/
 * self
 */
class Solution {
  public int[][] merge(int[][] intervals) {
    if (intervals.length == 1) return intervals;
    Comparator<int[]> comp = new Comparator<int[]>() {
      @Override
      public int compare(int[] a, int[] b) {
       if (a[0] == b[0]) return a[1] - b[1];
       return a[0] - b[0];
      }
    };
    int pos = 0;
    int[][] ans = new int[intervals.length][2];
    int realLengh = intervals.length;
    Arrays.sort(intervals, comp);
    int[] temp = new int[]{intervals[0][0], intervals[0][1]};
    for (int i = 1; i < intervals.length; i++) {
      if (isOverlapping(intervals[i], temp)) {
        temp[0] = Math.min(intervals[i][0], temp[0]);
        temp[1] = Math.max(intervals[i][1], temp[1]);
        realLengh--;
      } else {
        ans[pos][0] = temp[0];
        ans[pos++][1] = temp[1];
        i++;
        temp[0] = intervals[i][0];
        temp[1] = intervals[i][1];
      }
    }
    return Arrays.copyOfRange(ans, 0, realLengh + 1);
  }

  private boolean isOverlapping(int[] a, int[] b) {
    return (b[0] >= a[0] && b[0] <= a[1]) || (b[1] >= a[0] && b[1] <= a[1]);
  }
}