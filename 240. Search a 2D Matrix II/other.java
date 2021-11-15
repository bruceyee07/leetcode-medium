/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 * https://leetcode.com/problems/search-a-2d-matrix-ii/discuss/66140/My-concise-O(m%2Bn)-Java-solution
 */
class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    int row = 0, col = matrix[0].length - 1;
    while (col >= 0 && row < matrix.length) {
      if (matrix[row][col] == target) return true;
      if (matrix[row][col] < target) {
        row++;
      } else {
        col--;
      }
    }
    return false;
  }
}