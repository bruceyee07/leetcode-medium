/**
 * https://leetcode.com/problems/generate-parentheses/
 * https://leetcode.com/problems/generate-parentheses/solution/
 */
class Solution {
  public List<String> generateParenthesis(int n) {
    List<String> combs = new ArrayList<String>();
    generateAll(new char[2 * n], 0, combs);
    return combs;
  }

  public void generateAll(char[] current, int pos, List<String> result) {
    if (pos == current.length) {
      if (isValid(current)) {
        result.add(new String(current));
      }
    } else {
      current[pos] = '(';
      generateAll(current, pos + 1, result);
      current[pos] = ')';
      generateAll(current, pos + 1, result);
    }
  }

  public boolean isValid(char[] current) {
    int balance = 0;
    for (char c : current) {
      if (c == '(') balance++;
      else balance--;
      if (balance < 0) return false;
    }
    return balance == 0;
  }
}