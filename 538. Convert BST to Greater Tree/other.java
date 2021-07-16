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
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 * https://leetcode.com/problems/convert-bst-to-greater-tree/solution/
 */
class Solution {
  private int sum = 0;

  public TreeNode convertBST(TreeNode root) {
    if (root != null) {
      convertBST(root.right);
      sum += root.val;
      root.val = sum;
      convertBST(root.left);
    }
    return root;
  }
}