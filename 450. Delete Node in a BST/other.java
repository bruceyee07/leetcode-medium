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
 * https://leetcode.com/problems/delete-node-in-a-bst/
 * https://leetcode.com/problems/delete-node-in-a-bst/discuss/93296/Recursive-Easy-to-Understand-Java-Solution
 * based on skyblue_cat's java solution
 */
class Solution {
  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) return null;
    if (key < root.val) {
      root.left = deleteNode(root.left, key);
    } else if (key > root.val) {
      root.right = deleteNode(root.right, key);
    } else {
      if (root.left == null) {
        return root.right;
      }
      if (root.right == null) {
        return root.left;
      }
      TreeNode rightSmallest = root.right;
      while (rightSmallest.left != null) {
        rightSmallest = rightSmallest.left;
      }
      rightSmallest.left = root.left;
      return root.right;
    }
    return root;
  }
}