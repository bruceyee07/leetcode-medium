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
 * https://leetcode.com/problems/binary-tree-pruning/
 * self
 */
class Solution {
  public TreeNode pruneTree(TreeNode root) {
    if (root == null) return null;
    if (root.left == null && root.right == null) return root.val == 0 ? null : root;
    TreeNode node = root;
    node.left = pruneTree(root.left);
    node.right = pruneTree(root.right);
    if (node.left == null && node.right == null) return node.val == 0 ? null : node;
    return node;
  }
}