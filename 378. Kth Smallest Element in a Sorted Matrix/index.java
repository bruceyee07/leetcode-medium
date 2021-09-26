/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * self
 */
class Solution {
  public int kthSmallest(int[][] matrix, int k) {
    int n = matrix.length;
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.addAll(Arrays.stream(matrix[i]).boxed().collect(Collectors.toList()));
    }
    Queue<Integer> q = new PriorityQueue<>((a, b) -> a - b);
    for (int x : list) {
      q.offer(x);
    }
    int i = 0;
    while (i++ < k - 1) {
      q.poll();
    }
    return (int)q.poll();
  }
}