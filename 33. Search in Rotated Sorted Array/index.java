/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * self
 */
class Solution {
  public int search(int[] nums, int target) {
    int pos = -1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] < nums[i - 1]) {
        pos = i;
        break;
      }
    }
    System.out.println(pos);
    if (pos < 0) {
      int ans = Arrays.binarySearch(nums, target);
      return ans >= 0 ? ans : -1;
    }
    int headPos = Arrays.binarySearch(Arrays.copyOfRange(nums, 0, pos), target);
    if (headPos >= 0) return headPos;
    int tailPos = Arrays.binarySearch(Arrays.copyOfRange(nums, pos, nums.length), target);
    if (tailPos >= 0) return tailPos + pos;
    return -1;
  }
}

binarySearch() 方法的返回值为：
1、如果找到关键字，则返回值为关键字在数组中的位置索引，且索引从 0 开始
2、如果没有找到关键字，返回值为负的插入点值，所谓插入点值就是第一个比关键字大的元素在数组中的位置索引，而且这个位置索引从 1 开始。

调用binarySearch()方法前要先调用sort方法对数组进行排序，否则得出的返回值不定，这时二分搜索算法决定的