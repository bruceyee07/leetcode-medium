/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
 * self
 */
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
 * https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
 * self
 */
class Solution {
  public TreeNode lcaDeepestLeaves(TreeNode root) {
    HashMap<TreeNode, Integer> map = new HashMap<>();
    TreeNode node = root;
    int depth = 0;
    map.put(node, depth);
    if (node.left != null) {
      map.put(node.left, depth++);
      node = node.left;
    }
    if (node.right != null) {
      map.put(node.right, depth++);
      node = node.right;
    }
    return node;
  }
}

// same with 865: https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/