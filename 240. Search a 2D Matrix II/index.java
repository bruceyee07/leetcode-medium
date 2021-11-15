/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 * self
 */
class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length, n = matrix[0].length;
    for (int i = 0; i < m; i++) {
      if (Arrays.binarySearch(matrix[i], target) >= 0) return true;
    }
    return false;
  }
}