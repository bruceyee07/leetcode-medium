/**
 * https://leetcode.com/problems/number-of-islands/
 * https://leetcode.com/problems/number-of-islands/discuss/56349/7-lines-Python-~14-lines-Java
 */
class Solution {
  public int numIslands(char[][] grid) {
    char[][] g = grid;
    int cnt = 0;
    for (int i = 0; i < g.length; i++) {
      for (int j = 0; j < g[i].length; j++) {
        cnt += dfs(g, i, j);
      }
    }
    return cnt;
  }

  public int dfs(char[][] g, int i, int j) {
    if (i < 0 || i >= g.length || j < 0 || j >= g[i].length || g[i][j] == '0') return 0;
    g[i][j] = '0';
    dfs(g, i + 1, j);
    dfs(g, i - 1, j);
    dfs(g, i, j + 1);
    dfs(g, i, j - 1);
    return 1;
  }
}