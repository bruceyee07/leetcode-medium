/**
 * https://leetcode.com/problems/subsets/
 * https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 */
class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    backtrack(ans, new ArrayList<Integer>(), nums, 0);
    return ans;
  }

  public void backtrack(List<List<Integer>> ans, List<Integer> subset, int[] nums, int start) {
    ans.add(new ArrayList<Integer>(subset));
    for (int i = start; i < nums.length; i++) {
      subset.add(nums[i]);
      backtrack(ans, subset, nums, i + 1);
      subset.remove(subset.size() - 1);
    }
  }
}
