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
 * https://leetcode.com/problems/delete-leaves-with-a-given-value/
 * https://leetcode.com/problems/delete-leaves-with-a-given-value/discuss/484264/JavaC%2B%2BPython-Recursion-Solution
 */
class Solution {
  public TreeNode removeLeafNodes(TreeNode root, int target) {
    if (root.left != null) root.left = removeLeafNodes(root.left, target);
    if (root.right != null) root.right = removeLeafNodes(root.right, target);
    return root.left == root.right && root.val == target ? null : root;
  }
}