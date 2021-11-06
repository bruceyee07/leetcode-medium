/**
 * https://leetcode.com/problems/subsets-ii/
 * https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
 */
class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(ans, new ArrayList<Integer>(), nums, 0);
    return ans;
  }

  public void backtrack(List<List<Integer>> ans, List<Integer> subset, int[] nums, int start) {
    ans.add(new ArrayList<Integer>(subset));
    for (int i = start; i < nums.length; i++) {
      if (i > start && nums[i] == nums[i - 1]) continue;
      subset.add(nums[i]);
      backtrack(ans, subset, nums, i + 1);
      subset.remove(subset.size() - 1);
    }
  }
}