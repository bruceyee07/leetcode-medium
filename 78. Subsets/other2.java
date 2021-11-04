/**
 * https://leetcode.com/problems/subsets/
 * https://leetcode.com/problems/subsets/solution/
 */
class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    ans.add(new ArrayList<Integer>());
    for (int val : nums) {
      List<List<Integer>> newSubsets = new ArrayList<>();
      for (List<Integer> existSubset : ans) {
        // https://www.reddit.com/r/javahelp/comments/ljc64o/confused_on_a_particular_expression/
        // newSubsets.add(new ArrayList<Integer>(existSubset){{add(val);}});
        List<Integer> cur = new ArrayList<>(existSubset);
        cur.add(val);
        newSubsets.add(cur);
      }
      ans.addAll(newSubsets);
    }
    return ans;
  }
}
