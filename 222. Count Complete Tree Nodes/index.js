/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @description https://leetcode.com/problems/count-complete-tree-nodes/
 * @type self
 * @param {TreeNode} root
 * @return {number}
 */
var countNodes = function(root) {
  return preorder(root).length;
};

function preorder(root) {
  if (!root) {
    return [];
  }
  return [root.val].concat(preorder(root.left), preorder(root.right));
}