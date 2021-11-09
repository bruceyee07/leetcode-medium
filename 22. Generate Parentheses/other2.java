/**
 * https://leetcode.com/problems/generate-parentheses/
 * https://leetcode.com/problems/generate-parentheses/solution/
 */
class Solution {
  public List<String> generateParenthesis(int n) {
    List<String> ans = new ArrayList<String>();
    backtrack(ans, new StringBuilder(), 0, 0, n);
    return ans;
  }

  public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int n) {
    if (cur.length() == n * 2) {
      ans.add(cur.toString());
    } else {
      if (open < n) {
        cur.append("(");
        backtrack(ans, cur, open + 1, close, n);
        cur.deleteCharAt(cur.length() - 1);
      }
      if (close < open) {
        cur.append(")");
        backtrack(ans, cur, open, close + 1, n);
        cur.deleteCharAt(cur.length() - 1);
      }
    }
  }
}