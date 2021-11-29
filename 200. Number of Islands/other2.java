/**
 * https://leetcode.com/problems/number-of-islands/
 * https://leetcode.com/problems/number-of-islands/solution/
 * https://leetcode.com/problems/number-of-islands/discuss/56354/1D-Union-Find-Java-solution-easily-generalized-to-other-problems @optimist81 @chipbk10
 * Union Find
 */
class Solution {
  class UnionFind {
    int cnt;
    int[] parent;
    int[] rank;
    public UnionFind(char[][] grid) { // for problem 200
      int m = grid.length, n = grid[0].length;
      cnt = 0;
      parent = new int[m * n];
      rank = new int[m * n];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (grid[i][j] == '1') {
            parent[i * n + j] = i * n + j;
            cnt++;
          }
          rank[i * n + j] = 0;
        }
      }
    }

    public int find(int i) { // path compression
      if (parent[i] == i) return parent[i];
      return parent[i] = find(parent[i]);
    }

    public void union(int x, int y) { // union with rank
      int rootx = find(x), rooty = find(y);
      if (rootx != rooty) {
        if (rank[rootx] > rank[rooty]) {
          parent[rooty] = rootx;
        } else if (rank[rootx] < rank[rooty]) {
          parent[rootx] = rooty;
        } else {
          parent[rooty] = rootx;
          rank[rootx]++;
        }
        cnt--;
      }
    }

    public int getCount() {
      return cnt;
    }
  }

  public int numIslands(char[][] grid) {
    int m = grid.length, n = grid[0].length;
    int[][] directions = {{0,1}, {1,0}}; // only check forward and downward directions
    UnionFind uf = new UnionFind(grid);
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          grid[i][j] = '0';
          for (int[] d : directions) {
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
              uf.union(i * n + j, x * n + y);
            }
          }
        }
      }
    }
    return uf.getCount();
  }
}