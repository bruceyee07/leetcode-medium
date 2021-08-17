/**
 * https://leetcode.com/problems/perfect-squares/
 * https://leetcode.com/problems/perfect-squares/discuss/71488/Summary-of-4-different-solutions-(BFS-DP-static-DP-and-mathematics) @s961206
 */
class Solution {
  public int numSquares(int n) {
    Queue<Integer> q = new LinkedList();
    int step = 0;
    Set<Integer> visited = new HashSet();
    q.add(0);
    visited.add(0);
    
    while(!q.isEmpty()){
      int size = q.size();
      ++step;
      for(int i = 0; i < size; ++i){
        int remian = n - q.remove();
        for(int j = 1; j <= Math.sqrt(remian); ++j){
          int v = n - remian + j * j;
          if(v == n) return step;
          if(!visited.add(v)) continue;
          q.add(v);
        }
      }
    }
 
    return n;
  }
}