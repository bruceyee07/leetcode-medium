/**
 * https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
 * self
 */
class Solution {
  public int minSteps(String s, String t) {
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
      map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
    }
    int count = 0;
    for (char c : map.keySet()) {
      if (map.get(c) > 0) {
        count += map.get(c);
      }
    }
    return count;
  }
}