/**
 * https://leetcode.com/problems/count-square-submatrices-with-all-ones/
 * https://leetcode.com/problems/count-square-submatrices-with-all-ones/discuss/441306/JavaC%2B%2BPython-DP-solution
 */
class Solution {
  public int countSquares(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    int ans = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] > 0 && i > 0 && j > 0) {
          matrix[i][j] = Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1])) + 1;
        }
        ans += matrix[i][j];
      }
    }
    return ans;
  }
}