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
 * https://leetcode.com/problems/validate-binary-search-tree/
 * https://leetcode.com/problems/validate-binary-search-tree/discuss/32109/My-simple-Java-solution-in-3-lines 
 * based on waiyip's java solution
 */
class Solution {
  public boolean isValidBST(TreeNode root) {
    return helper(root, null, null);
  }
  public boolean helper(TreeNode root, TreeNode min, TreeNode max) {
    if (root == null) 
      return true;
    if ((min != null && root.val <= min.val) || (max != null && root.val >= max.val)) 
      return false;
    return helper(root.left, min, root) && helper(root.right, root, max);
  }
}