/**
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/discuss/516491/Java-Union-Find-DFS-BFS-Solutions-Complexity-Explain-Clean-code
 * BFS
 */
class Solution {
  public int countComponents(int n, int[][] edges) {
    List<Integer>[] graph = new List[n];
    for (int i = 0; i < n; i++) graph[i] = new ArrayList<Integer>();
    for (int[] edge : edges) {
      graph[edge[0]].add(edge[1]);
      graph[edge[1]].add(edge[0]);
    }
    int cnt = 0;
    boolean[] visited = new boolean[n];
    for (int node = 0; node < n; node++) cnt += bfs(node, graph, visited);
    return cnt;
  }

  public int bfs(int node, List<Integer>[] graph, boolean[] visited) {
    if (visited[node]) return 0;
    visited[node] = true;
    Queue<Integer> q = new LinkedList<>();
    q.offer(node);
    while (!q.isEmpty()) {
      int cur = q.poll();
      for (int v : graph[cur]) {
        if (!visited[v]) {
          visited[v] = true;
          q.offer(v);
        }
      }
    }
    return 1;
  }
}