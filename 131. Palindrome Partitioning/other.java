/**
 * https://leetcode.com/problems/palindrome-partitioning/
 * https://leetcode.com/problems/palindrome-partitioning/solution/
 */
class Solution {
  public List<List<String>> partition(String s) {
    List<List<String>> ans = new ArrayList<>();
    backtrack(s, ans, new ArrayList<String>(), 0);
    return ans;
  }

  public void backtrack(String s, List<List<String>> ans, List<String> cur, int start) {
    if (start >= s.length()) {
      ans.add(new ArrayList<String>(cur));
    } else {
      for (int end = start; end < s.length(); end++) {
        if (isPalindrome(s, start, end)) {
          cur.add(s.substring(start, end + 1));
          backtrack(s, ans, cur, end + 1);
          cur.remove(cur.size() - 1);
        }
      }
    }
  }

  public boolean isPalindrome(String s, int left, int right) {
    while (left < right) {
      if (s.charAt(left++) != s.charAt(right--)) return false;
    }
    return true;
  }
}