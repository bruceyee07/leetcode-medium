/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/discuss/1729/11-line-simple-Java-solution-O(n)-with-explanation
 */
class Solution {
  public int lengthOfLongestSubstring(String s) {
    if (s.length() == 0) return 0;
    Map<Character, Integer> map = new HashMap<>();
    int max = 0;
    for (int start = 0, end = 0; end < s.length(); end++) {
      Character cur = s.charAt(end);
      if (map.containsKey(cur)) {
        start = Math.max(start, map.get(cur) + 1);
      }
      map.put(cur, end);
      max = Math.max(max, end - start + 1);
    }
    return max;
  }
}