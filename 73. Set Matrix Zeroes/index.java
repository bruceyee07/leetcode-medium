/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 * self
 */
class Solution {
  public void setZeroes(int[][] matrix) {
    List<Integer> row = new ArrayList<>();
    List<Integer> col = new ArrayList<>();
    int m = matrix.length, n = matrix[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          row.add(i);
          col.add(j);
        }
      }
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (row.contains(i) || col.contains(j)) {
          matrix[i][j] = 0;
        }
      }
    }
  }
}