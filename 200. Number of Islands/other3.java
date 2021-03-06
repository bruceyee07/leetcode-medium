/**
 * https://leetcode.com/problems/number-of-islands/
 * https://leetcode.com/problems/number-of-islands/discuss/56359/Very-concise-Java-AC-solution
 * DFS
 */
class Solution {
  public int numIslands(char[][] grid) {
    int cnt = 0;
    int m = grid.length, n = grid[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          dfs(grid, i, j);
          cnt++;
        }
      }
    }
    return cnt;
  }

  public void dfs(char[][] grid, int i, int j) {
    if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;
    grid[i][j] = '0';
    dfs(grid, i + 1, j);
    dfs(grid, i - 1, j);
    dfs(grid, i, j + 1);
    dfs(grid, i, j - 1);
  }
}