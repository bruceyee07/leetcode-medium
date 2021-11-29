/**
 * https://leetcode.com/problems/number-of-islands/
 * https://leetcode.com/problems/number-of-islands/discuss/56338/Java-DFS-and-BFS-solution
 * BFS
 */
class Solution {
  public int numIslands(char[][] grid) {
    int cnt = 0;
    int m = grid.length, n = grid[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          bfs(grid, i, j);
          cnt++;
        }
      }
    }
    return cnt;
  }

  public void bfs(char[][] grid, int i, int j) {
    int m = grid.length, n = grid[0].length;
    if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') return;
    grid[i][j] = '0';
    Queue<Integer> q = new LinkedList<>();
    q.offer(i * n + j);
    while (!q.isEmpty()) {
      int cur = q.poll();
      int x = cur / n, y = cur % n;
      if (x > 0 && grid[x - 1][y] == '1') {  
        q.offer((x - 1) * n + y);  
        grid[x - 1][y] = '0';  
      }  
      if (x < m - 1 && grid[x + 1][y] == '1') {  
        q.offer((x + 1) * n + y);  
        grid[x + 1][y] = '0';  
      }
      if (y > 0 && grid[x][y - 1] == '1') {  
        q.offer(x * n + y - 1);  
        grid[x][y - 1] = '0';  
      }
      if (y < n -1 && grid[x][y + 1] == '1') {  
        q.offer(x * n + y + 1);  
        grid[x][y + 1] = '0';  
      }
    }
  }
}