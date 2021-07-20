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
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/discuss/161268/C%2B%2BJavaPython-One-Pass-Real-O(N)
 */
class Solution {
  int preIndex = 0, posIndex = 0;
  public TreeNode constructFromPrePost(int[]pre, int[]post) {
    TreeNode root = new TreeNode(pre[preIndex++]);
    if (root.val != post[posIndex])
      root.left = constructFromPrePost(pre, post);
    if (root.val != post[posIndex])
      root.right = constructFromPrePost(pre, post);
    posIndex++;
    return root;
  }
}