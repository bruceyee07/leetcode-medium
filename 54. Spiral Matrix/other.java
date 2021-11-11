/**
 * https://leetcode.com/problems/spiral-matrix/
 * https://leetcode.com/problems/spiral-matrix/discuss/20599/Super-Simple-and-Easy-to-Understand-Solution @xietao0221
 */
class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> ans = new ArrayList<>();
    int rowStart = 0, rowEnd = matrix.length - 1, colStart = 0, colEnd = matrix[0].length - 1;
    while (rowStart <= rowEnd && colStart <= colEnd) {
      for (int i = colStart; i <= colEnd; i++) ans.add(matrix[rowStart][i]);
      rowStart++;
      for (int i = rowStart; i <= rowEnd; i++) ans.add(matrix[i][colEnd]);
      colEnd--;
      if (rowStart > rowEnd || colStart > colEnd) break;
      for (int i = colEnd; i>= colStart; i--) ans.add(matrix[rowEnd][i]);
      rowEnd--;
      for (int i = rowEnd; i >= rowStart; i--) ans.add(matrix[i][colStart]); 
      colStart++;
    }
    return ans;
  }
}
----------- |
1 2   3  4  |
5 6   7  8  |
9 10  11 12 |
13 14 15 16 |
17 18 19 20 |
-------------

[1,2,3,4,8,12,16,20,19,18,17,13,9,5,6,7,11,15,14,10]

row1, coln, rown, col1, row2, coln-1, rown-1, col2
