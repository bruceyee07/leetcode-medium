/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
 * https://leetcode.com/problems/maximum-width-of-binary-tree/
 * https://leetcode.com/problems/maximum-width-of-binary-tree/discuss/106654/JavaC%2B%2B-Very-simple-dfs-solution
 */
class Solution {
  private int max = 1;
  public int widthOfBinaryTree(TreeNode root) {
    if (root == null) return 0;
    List<Integer> startOfLevel = new LinkedList<>();
    helper(root, 0, 1, startOfLevel);
    return max;
  }
  public void helper(TreeNode root, int level, int index, List<Integer> list) {
    if (root == null) return;
    if (level == list.size()) list.add(index);
    max = Math.max(max, index + 1 - list.get(level));
    helper(root.left, level + 1, index * 2, list);
    helper(root.right, level + 1, index * 2 + 1, list);
  }
}