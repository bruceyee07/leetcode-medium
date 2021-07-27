/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @description https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * @type self
 * @param {TreeNode} root
 * @return {void} Do not return anything, modify root in-place instead.
 */
var flatten = function(root) {
  var preorderArr = preorder(root);

  for (let i = 1; i < preorderArr.length; i++) {
    root.left = null;
    root.right = new TreeNode(preorderArr[i]);
    root = root.right;
  }

};

function preorder(root) {
  if (!root) {
    return [];
  }
  return [root.val].concat(preorder(root.left), preorder(root.right));
}