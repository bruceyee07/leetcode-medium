/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/discuss/8109/My-recursive-solution-using-Java @davidluoyes
 * self
 */
class Solution {
  public List<String> letterCombinations(String digits) {
    Map<Character, String[]> m = new HashMap<>();
    m.put('2', new String[]{"a", "b", "c"});
    m.put('3', new String[]{"d", "e", "f"});
    m.put('4', new String[]{"g", "h", "i"});
    m.put('5', new String[]{"j", "k", "l"});
    m.put('6', new String[]{"m", "n", "o"});
    m.put('7', new String[]{"p", "q", "r", "s"});
    m.put('8', new String[]{"t", "u", "v"});
    m.put('9', new String[]{"w", "x", "y", "z"});

    List<String> ans = new ArrayList<>();
    if (digits == null || digits.length() == 0) return ans;
    backtrack(digits, ans, m, new StringBuilder(), 0);
    return ans;
  }

  public void backtrack(String digits, List<String> ans, Map<Character, String[]> m, StringBuilder sb, int start) {
    if (sb.length() == digits.length()) {
      ans.add(sb.toString());
      return;
    }
    char key = digits.charAt(start);
    for (int i = 0; i < m.get(key).length; i++) {
      sb.append(m.get(key)[i]);
      backtrack(digits, ans, m, sb, start + 1);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}