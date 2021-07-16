/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @description https://leetcode.com/problems/convert-bst-to-greater-tree/
 * @tutorial https://leetcode.com/problems/convert-bst-to-greater-tree/solution/
 * @param {TreeNode} root
 * @return {TreeNode}
 */
var convertBST = function(root) {
  var sum = 0;

  function traverse(root) {
    if (root !== null) {
      traverse(root.right);
      sum += root.val;
      root.val = sum;
      traverse(root.left);
    }
  }
  
  traverse(root);
  return root;
};