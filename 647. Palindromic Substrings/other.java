/**
 * https://leetcode.com/problems/palindromic-substrings/
 * https://leetcode.com/problems/palindromic-substrings/discuss/105689/Java-solution-8-lines-extendPalindrome @mockito_308 
 */
class Solution {
  public int countSubstrings(String s) {
    int cnt = 0;
    for (int i = 0; i < s.length(); i++) { // i is the mid point
      cnt += extendPalindrome(s, i, i); // odd length;
      cnt += extendPalindrome(s, i, i + 1); // even length
    }
    return cnt;
  }

  public int extendPalindrome(String s, int left, int right) {
    int cnt = 0;
    while (left >= 0 && right < s.length() && (s.charAt(left) == s.charAt(right))) {
      cnt++;
      left--;
      right++;
    }

    return cnt;
  }
}