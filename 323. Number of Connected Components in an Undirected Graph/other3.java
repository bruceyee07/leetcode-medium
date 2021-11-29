/**
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/discuss/516491/Java-Union-Find-DFS-BFS-Solutions-Complexity-Explain-Clean-code
 * Union Find with Path Compression and Union by Size
 */
class Solution {
  public int countComponents(int n, int[][] edges) {
    int[] parents = new int[n];
    int[] sizes = new int[n];
    for (int i = 0; i < n; i++) {
      parents[i] = i;
      sizes[i] = 1;
    }
    for (int[] edge : edges) {
      int p1 = findParent(parents, edge[0]);
      int p2 = findParent(parents, edge[1]);
      if (p1 != p2) {
        if (sizes[p1] < sizes[p2]) {
          parents[p1] = p2;
          sizes[p2] += sizes[p1];
        } else {
          parents[p2] = p1;
          sizes[p1] += sizes[p2];
        }
        n--;
      }
    }
    return n;
  }

  public int findParent(int[] parents, int node) {
    if (parents[node] == node) return node;
    return parents[node] = findParent(parents, parents[node]);
  }
}