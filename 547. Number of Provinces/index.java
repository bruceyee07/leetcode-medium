/**
 * https://leetcode.com/problems/number-of-provinces/
 * self
 */
class Solution {
  public int findCircleNum(int[][] isConnected) {
    UnionFind uf = new UnionFind(isConnected);
    for (int i = 0; i < isConnected.length; i++) {
      for (int j = 0; j < isConnected[i].length; j++) {
        if (i != j && isConnected[i][j] == 1) {
          uf.union(i, j);
        }
      }
    }
    return uf.getCount();
  }

  class UnionFind {
    int count;
    int[] parent;
    int[] size;

    public UnionFind(int[][] isConnected) {
      int n = isConnected.length;
      parent = new int[n];
      size = new int[n];
      count = n;
      for (int i = 0; i < n; i++) {
        parent[i] = i;
        size[i] = 1;
      }
    }

    public void union(int x, int y) {
      int p1 = find(x), p2 = find(y);
      if (p1 != p2) {
        if (size[p1] > size[p2]) {
          parent[p2] = p1;
          size[p1] += size[p2];
        } else {
          parent[p1] = p2;
          size[p2] += size[p1];
        }
        count--;
      }
    }
  
    public int find(int id) {
      if (parent[id] == id) return parent[id];
      return parent[id] = find(parent[id]);
    }

    public int getCount() {
      return count;
    }
  }
}