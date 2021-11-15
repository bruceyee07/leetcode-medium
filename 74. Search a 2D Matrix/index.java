/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 * self
 */
class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length, n = matrix[0].length;
    int[] arr = new int[m * n];
    for (int i = 0; i < m * n; i++) {
      int row = i / n;
      int col = i % n;
      arr[i] = matrix[row][col];
    }
    return Arrays.binarySearch(arr, target) > 0;
  }
}