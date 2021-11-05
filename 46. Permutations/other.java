/**
 * https://leetcode.com/problems/permutations/
 * https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 */
class Solution {
  public List<List<Integer>> backtrack(List<Integer> cur, int[] nums, List<List<Integer>> ans) {
    if (cur.size() == nums.length) {
      ans.add(new ArrayList<Integer>(cur));
      return ans;
    }
    for (int val : nums) {
      if (cur.contains(val)) continue;
      cur.add(val);
      backtrack(cur, nums, ans);
      cur.remove(cur.size() - 1);
    }
    return ans;
  }

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    ans = backtrack(new ArrayList<Integer>(), nums, ans);
    return ans;
  }
}