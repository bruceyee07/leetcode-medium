/**
 * https://leetcode.com/problems/subsets/
 * https://leetcode.com/problems/subsets/solution/
 */
class Solution {
  public List<List<Integer>> backtrack(
    int firstElementIndex, 
    List<Integer> currentCombination, 
    int subsetSize, 
    int[] nums, 
    List<List<Integer>> ans
  ) {
    if (currentCombination.size() == subsetSize) {
      ans.add(new ArrayList(currentCombination));
      return ans;
    }
    for (int i = firstElementIndex; i < nums.length; i++) {
      currentCombination.add(nums[i]);
      backtrack(i + 1, currentCombination, subsetSize, nums, ans);
      currentCombination.remove(currentCombination.size() - 1);
    }
    return ans;
  }

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    for (int k = 0; k <= nums.length; k++) {
      ans = backtrack(0, new ArrayList<Integer>(), k, nums, ans);
    }
    return ans;
  }
}