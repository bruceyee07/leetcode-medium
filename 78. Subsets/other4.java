/**
 * https://leetcode.com/problems/subsets/
 * https://leetcode.com/problems/subsets/discuss/122645/3ms-easiest-solution-no-backtracking-no-bit-manipulation-no-dfs-no-bullshit
 */
class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    ans.add(new ArrayList<Integer>());
    for (int val : nums) {
      int size = ans.size();
      for (int i = 0; i < size; i++) {
        List<Integer> subset = new ArrayList<>(ans.get(i));
        subset.add(val);
        ans.add(subset);
      }
    }
    return ans;
  }
}
