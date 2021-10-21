/**
 * https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
 * https://leetcode.com/problems/number-of-good-ways-to-split-a-string/discuss/754719/Some-hints-to-help-you-solve-this-problem-on-your-own @lionkingeatapple @sanbhat
 */
class Solution {
  public int numSplits(String s) {
    Set<Character> set = new HashSet<>();
    int n = s.length();
    int[] prefix = new int[n];
    int[] suffix = new int[n];
    for (int i = 0; i < n; i++) {
      set.add(s.charAt(i));
      prefix[i] = set.size();
    }
    set.clear();
    for (int i = n - 1; i >= 0; i--) {
      set.add(s.charAt(i));
      suffix[i] = set.size();
    }
    int cnt = 0;
    for (int i = 1; i < n; i++) {
      if (prefix[i - 1] == suffix[i]) {
        cnt++;
      }
    }
    return cnt;
  }
}