/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 * https://leetcode.com/problems/search-a-2d-matrix/discuss/26220/Don't-treat-it-as-a-2D-matrix-just-treat-it-as-a-sorted-list
 */
class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length, n = matrix[0].length;
    int lo = 0, hi = m * n - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (matrix[mid / n][mid % n] == target) return true;
      if (matrix[mid / n][mid % n] < target) {
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }
    return false;
  }
}