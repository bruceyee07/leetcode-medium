/**
 * https://leetcode.com/problems/reduce-array-size-to-the-half/
 * self
 */
class Solution {
  public int minSetSize(int[] arr) {
    int len = arr.length, half = arr.length / 2;

    HashMap<Integer, Integer> map = new HashMap<>();
    for (int val : arr) {
      map.put(val, map.getOrDefault(val, 0) + 1);
    }

    Queue<Integer[]> q = new PriorityQueue<>((a, b) -> b[1] - a[1]);
    for (Integer val : map.keySet()) {
      q.offer(new Integer[]{val, map.get(val)});
    }
    
    int count = 0;
    while (len > half) {
      count++;
      len -= q.poll()[1];
    }
    return count;
  }
}