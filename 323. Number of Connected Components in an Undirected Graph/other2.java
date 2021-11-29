/**
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/discuss/77574/Easiest-2ms-Java-Solution
 * Union Find
 */
class Solution {
  public int countComponents(int n, int[][] edges) {
    int[] forest = new int[n];
    for (int i = 0; i < n; i++) {
      forest[i] = i;
    }
    for (int[] edge : edges) {
      int r1 = find(forest, edge[0]);
      int r2 = find(forest, edge[1]);
      if (r1 != r2) {
        n--;
        forest[r1] = r2;
      }
    }
    return n;
  }

  public int find(int[] forest, int node) {
    if (forest[node] == node) return node;
    return forest[node] = find(forest, forest[node]);
  }
}