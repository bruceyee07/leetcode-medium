/**
 * https://leetcode.com/problems/subsets/
 * https://leetcode.com/problems/subsets/solution/
 */
class Solution {
  public List<List<Integer>> backtrack(int startIndex, int[] nums, List<Integer> subset, int subsetSize, List<List<Integer>> ans) {
    if (subset.size() == subsetSize) {
      ans.add(new ArrayList<Integer>(subset));
      return ans;
    }
    for (int i = startIndex; i < nums.length; i++) {
      subset.add(nums[i]);
      ans = backtrack(i + 1, nums, subset, subsetSize, ans);
      subset.remove(subset.size() - 1);
    }
    return ans;
  }

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    for (int i = 0; i <= nums.length; i++) {
      ans = backtrack(0, nums, new ArrayList<Integer>(), i, ans);
    }
    return ans;
  }
}