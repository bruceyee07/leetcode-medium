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
  var inorderArr = inorder(root);
  for (let i = 0; i < inorderArr.length - 1; i++) {
    if (inorderArr[i] >= inorderArr[i + 1]) {
      return false;
    }
  }
  return true;
};

function inorder(root) {
  if (!root) {
    return [];
  }
  return inorder(root.left).concat([root.val], inorder(root.right));
}