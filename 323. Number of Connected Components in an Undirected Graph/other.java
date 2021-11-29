/**
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/solution/
 * DFS
 */
class Solution {
  public int countComponents(int n, int[][] edges) {
    int cnt = 0;
    int[] visited = new int[n];
    List<Integer>[] adjacencyList = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      adjacencyList[i] = new ArrayList<Integer>();
    }
    for (int i = 0; i < edges.length; i++) {
      adjacencyList[edges[i][0]].add(edges[i][1]);
      adjacencyList[edges[i][1]].add(edges[i][0]);
    }
    for (int i = 0; i < n; i++) {
      if (visited[i] == 0) {
        cnt++;
        dfs(adjacencyList, visited, i);
      }
    }
    return cnt;
  }

  public void dfs(List<Integer>[] adjacencyList, int[] visited, int startNode) {
    visited[startNode] = 1;
    for (int i = 0; i < adjacencyList[startNode].size(); i++) {
      if (visited[adjacencyList[startNode].get(i)] == 0) {
        dfs(adjacencyList, visited, adjacencyList[startNode].get(i));
      }
    }
  }
}