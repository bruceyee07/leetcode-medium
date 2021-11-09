/**
 * https://leetcode.com/problems/generate-parentheses/
 * self
 */
class Solution {
  public List<String> generateParenthesis(int n) {
    List<String> ans = new ArrayList<>();
    String[] arr = new String[2 * n];
    for (int i = 0; i < 2 * n; i++) {
      arr[i] = i % 2 == 0 ? "(" : ")";
    }
    List<List<String>> all = permutations(arr);
    for (List<String> item : all) {
      String candidate = "";
      for (String it : item) {
        candidate += it;
      }
      if (isValid(candidate)) {
        ans.add(candidate);
      }
    }
    return ans;
  }

  public List<List<String>> permutations(String[] arr) {
    List<List<String>> list = new ArrayList<>();
    backtrack(arr, list, new ArrayList<String>());
    return list;
  }

  public void backtrack(String[] arr, List<List<String>> list, List<String> cur) {
    if (cur.size() == arr.length) {
      list.add(new ArrayList<String>(cur));
    } else {
      for (int i = 0; i < arr.length; i++) {
        if (cur.contains(arr[i])) continue;
        cur.add(arr[i]);
        backtrack(arr, list, cur);
        cur.remove(cur.size() - 1);
      }
    }
  }

  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == '(') {
        stack.push(')');
      } else if (stack.isEmpty() || stack.pop() != c) {
        return false;
      }
    }
    return stack.isEmpty();
  }
}