/**
 * https://leetcode.com/problems/count-sorted-vowel-strings/
 * https://leetcode.com/problems/count-sorted-vowel-strings/discuss/918507/Java-DP-O(n)-time-Easy-to-understand
 */
class Solution {
  public int countVowelStrings(int n) {
    int a = 1, e = 1, i = 1, o = 1, u = 1;
    while (n-- > 1) {
      a = (a + e + i + o + u);
      e = (e + i + o + u);
      i = (i + o + u);
      o = (o + u);
      u = u;
    }
    return a + e + i + o + u;
  }
}