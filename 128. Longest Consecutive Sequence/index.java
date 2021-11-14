/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * self
 */
class Solution {
  public int longestConsecutive(int[] nums) {
    Arrays.sort(nums);
    LinkedList<Integer> l = new LinkedList<>();
    int max = 0;
    for (int val : nums) {
      if (l.isEmpty() || l.getLast() + 1 == val) {
        l.add(val);
      } else if (l.getLast()== val) {
        continue;
      } else {
        l.clear();
        l.add(val);
      }
      max = Math.max(max, l.size());
    }
    return max;
  }
}