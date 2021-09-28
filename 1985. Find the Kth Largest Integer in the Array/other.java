/**
 * https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/
 * https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/discuss/1431847/C%2B%2BJavaPython-3-solutions%3A-MinHeap-MaxHeap-QuickSelect-Clean-and-Concise
 */
class Solution {
  public String kthLargestNumber(String[] nums, int k) {
    Queue<String> q = new PriorityQueue<>((a, b) -> {
      if (a.length() == b.length()) { // If the same length then compare by their string
        return a.compareTo(b);
      }
      return Integer.compare(a.length(), b.length()); // Compare by their length
    });
    for (String s : nums) {
      q.offer(s);
      if (q.size() > k) {
        q.poll();
      }
    }
    return q.peek();
  }
}