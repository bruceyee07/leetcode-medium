/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/discuss/8109/My-recursive-solution-using-Java
 */
class Solution {
  public List<String> letterCombinations(String digits) {
    List<String> ans = new ArrayList<>();
    if (digits == null || digits.length() == 0) return ans;
    char[][] map = {{}, {}, {'a','b','c'}, {'d','e','f'}, {'g','h','i'}, {'j','k','l'}, {'m','n','o'}, {'p','q','r','s'}, {'t','u','v'}, {'w','x','y','z'}};
    backtrack(digits, map, ans, new StringBuilder(), 0);
    return ans;
  }

  private void backtrack(String digits, char[][] map, List<String> ans, StringBuilder sb, int start) {
    if (sb.length() == digits.length()) {
      ans.add(sb.toString());
      return;
    }
    int digit = digits.charAt(start) - '0';
    for (int i = 0; i < map[digit].length; i++) {
      sb.append(map[digit][i]);
      backtrack(digits, map, ans, sb, start + 1);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}