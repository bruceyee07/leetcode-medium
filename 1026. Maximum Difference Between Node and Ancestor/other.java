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
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/solution/
 */
class Solution {
  public int maxAncestorDiff(TreeNode root) {
    if (root == null) return 0;
    return helper(root, root.val, root.val);
  }

  public int helper(TreeNode node, int curMax, int curMin) {
    if (node == null) return curMax - curMin;
    curMax = Math.max(curMax, node.val);
    curMin = Math.min(curMin, node.val);
    int left = helper(node.left, curMax, curMin);
    int right = helper(node.right, curMax, curMin);
    return Math.max(left, right);
  }
}