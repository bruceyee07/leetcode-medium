/**
 * https://leetcode.com/problems/permutations/
 * https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 */
class Solution {
  public void backtrack(List<List<Integer>> ans, List<Integer> perm, int[] nums) {
    if (perm.size() == nums.length) {
      ans.add(new ArrayList<Integer>(perm));
    } else {
      for (int i = 0; i < nums.length; i++) {
        if (perm.contains(nums[i])) continue;
        perm.add(nums[i]);
        backtrack(ans, perm, nums);
        perm.remove(perm.size() - 1);
      }
    }
  }

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    backtrack(ans, new ArrayList<Integer>(), nums);
    return ans;
  }
}