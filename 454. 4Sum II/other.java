/**
 * https://leetcode.com/problems/4sum-ii/
 * https://leetcode.com/problems/4sum-ii/discuss/93920/Clean-java-solution-O(n2)
 */
class Solution {
  public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums3.length; i++) {
      for (int j = 0; j < nums4.length; j++) {
        int sum = nums3[i] + nums4[j];
        map.put(sum, map.getOrDefault(sum, 0) + 1);
      }
    }
    int ans = 0;
    for (int i = 0; i < nums1.length; i++) {
      for (int j = 0; j < nums2.length; j++) {
        int sum = nums1[i] + nums2[j];
        ans += map.getOrDefault(-1 * sum, 0);
      }
    }
    return ans;
  }
}