/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 * https://leetcode.com/problems/set-matrix-zeroes/discuss/26008/My-AC-java-O(1)-solution-(easy-to-read)
 */
class Solution {
  public void setZeroes(int[][] matrix) {
    boolean firstRow = false, firstCol = false;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          matrix[0][j] = 0;
          matrix[i][0] = 0;
          if (i == 0) firstRow = true;
          if (j == 0) firstCol = true;
        }
      }
    }
    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }
    if (firstRow) {
      for (int j = 1; j < matrix[0].length; j++) {
        matrix[0][j] = 0;
      }
    }
    if (firstCol) {
      for (int i = 1; i < matrix.length; i++) {
        matrix[i][0] = 0;
      }
    }
  }
}