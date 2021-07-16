/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @description https://leetcode.com/problems/insert-into-a-binary-search-tree/
 * @type self
 * @param {TreeNode} root
 * @param {number} val
 * @return {TreeNode}
 */
var insertIntoBST = function(root, val) {
  var nodeToInsert = new TreeNode(val);
  if (!root) {
    return nodeToInsert;
  }

  var node = new TreeNode(root.val);;

  if (val < node.val) {
    node.right = root.right;
    node.left = insertIntoBST(root.left, val);
  } else {
    node.left = root.left;
    node.right = insertIntoBST(root.right, val);
  }

  return node;
};