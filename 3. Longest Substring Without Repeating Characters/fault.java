/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * self
 */
class Solution {
  public int lengthOfLongestSubstring(String s) {
    Set<Character> set = new HashSet<>();
    int max = 0, curMax = 0;
    for (int i = 0; i < s.length(); i++) {
      if (!set.contains(s.charAt(i))) {
        set.add(s.charAt(i));
        curMax++;
        max = Math.max(max, curMax);
      } else {
        set.clear();
        curMax = 0;
      }
    }
    return max;
  }
}