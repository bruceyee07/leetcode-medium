/**
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 * self
 * TLE
 */
class Solution {
  public int longestSubstring(String s, int k) {
    List<String> list = getAllSubstrings(s);
    int max = 0;
    for (String ss : list) {
      if (checkValid(ss, k)) {
        max = Math.max(ss.length(), max);
      }
    }
    return max;
  }

  public List<String> getAllSubstrings(String s) {
    List<String> ans = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      for (int j = i + 1; j <= s.length(); j++) {
        ans.add(s.substring(i, j));
      }
    }
    return ans;
  }

  public boolean checkValid(String s, int k) {
    Map<Character, Integer> m = new HashMap<>();
    for (char c : s.toCharArray()) {
      m.put(c, m.getOrDefault(c, 0) + 1);
    }
    for (char c : m.keySet()) {
      if (m.get(c) < k) return false;
    }
    return true;
  }
}