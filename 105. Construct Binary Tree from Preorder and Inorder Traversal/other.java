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
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/discuss/34538/My-Accepted-Java-Solution @yavinci
 */
class Solution {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
  }

  public TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {
    if (preStart > preEnd || inStart > inEnd) return null;
    TreeNode root = new TreeNode(preorder[preStart]);
    int rootIndexOfInorder = map.get(preorder[preStart]);
    int sizeOfLeftTree = rootIndexOfInorder - inStart;
    root.left = helper(preorder, preStart + 1, preStart + sizeOfLeftTree, inorder, inStart, rootIndexOfInorder - 1, map);
    root.right = helper(preorder, preStart + sizeOfLeftTree + 1, preEnd, inorder, rootIndexOfInorder + 1, inEnd, map);
    return root;
  }
}