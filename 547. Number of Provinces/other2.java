import java.util.Queue;

/**
 * https://leetcode.com/problems/number-of-provinces/
 * https://leetcode.com/problems/number-of-provinces/solution/
 * BFS
 */
class Solution {
  public int findCircleNum(int[][] isConnected) {
    int[] visited = new int[isConnected.length];
    int count = 0;
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < isConnected.length; i++) {
      if (visited[i] == 0) {
        q.offer(i);
        while (!q.isEmpty()) {
          int cur = q.remove();
          visited[cur] = 1;
          for (int j = 0; j < isConnected[i].length; j++) {
            if (isConnected[cur][j] == 1 && visited[j] == 0) {
              q.offer(j);
            } 
          }
        }
        count++;
      }
    }
    return count;
  }
}