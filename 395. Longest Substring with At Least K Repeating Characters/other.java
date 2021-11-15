/**
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/solution/
 * divide and conquer
 */
class Solution {
  public int longestSubstring(String s, int k) {
    return helper(s, 0, s.length(), k);
  }

  public int helper(String s, int start, int end, int k) {
    if (end < k) return 0;
    int[] freqMap = new int[26];
    for (int i = start; i < end; i++) {
      freqMap[s.charAt(i) - 'a']++;
    }
    for (int mid = start; mid < end; mid++) {
      if (freqMap[s.charAt(mid) - 'a'] >= k) continue;
      int midNext = mid + 1;
      // To make it more efficient, we ignore all the invalid characters after the mid index as well, 
      // thereby reducing the number of recursive calls.
      while (midNext < end && freqMap[s.charAt(midNext) - 'a'] < k) midNext++;
      return Math.max(helper(s, start, mid, k), helper(s, midNext, end, k));
    }
    return end - start;
  }
}