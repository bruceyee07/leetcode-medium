/**
 * https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
 * https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/discuss/503450/JavaPython-3-Count-occurrences-and-sum-the-difference-w-analysis.
 */
class Solution {
  public int minSteps(String s, String t) {
    int[] count = new int[26];
    for (int i = 0; i < s.length(); i++) {
      ++count[s.charAt(i) - 'a'];
      --count[t.charAt(i) - 'a'];
    }
    return Arrays.stream(count).filter(i -> i > 0).sum();
  }
}