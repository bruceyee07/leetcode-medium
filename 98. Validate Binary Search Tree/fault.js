/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @description https://leetcode.com/problems/validate-binary-search-tree/
 * @type self
 * @param {TreeNode} root
 * @return {boolean}
 */
var isValidBST = function(root) {
  if (!root.left && !root.right) {
    return true;
  }
  if (!root.left) {
    return root.val < root.right.val && isValidBST(root.right);
  }
  if (!root.right) {
    return root.val > root.left.val && isValidBST(root.left);
  }
  return root.val > root.left.val && root.val < root.right.val && isValidBST(root.left) && isValidBST(root.right);
};