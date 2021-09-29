/**
 * https://leetcode.com/problems/find-k-closest-elements/
 * self
 */
class Solution {
  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    List<Integer> ans = new ArrayList<>();
    Queue<Integer> q = new PriorityQueue<>((a, b) -> {
      if (Math.abs(a - x) == Math.abs(b - x)) 
        return b - a;
      return Math.abs(b - x) - Math.abs(a - x);
    });
    if (x <= arr[0]) {
      ans.addAll(Arrays.stream(Arrays.copyOfRange(arr, 0, k)).boxed().collect(Collectors.toList()));
    } else if (x >= arr[arr.length - 1]) {
      ans.addAll(Arrays.stream(Arrays.copyOfRange(arr, arr.length - k, arr.length)).boxed().collect(Collectors.toList()));
    } else {
      for (int val : arr) {
        q.offer(val);
        if (q.size() > k)
          q.poll();
      }
      while (!q.isEmpty()) {
        ans.add(Integer.valueOf(q.poll()));
      }
      Collections.sort(ans);
    }

    return ans;
  }
}