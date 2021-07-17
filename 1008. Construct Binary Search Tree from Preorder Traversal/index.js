/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @description https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 * @type self
 * @param {number[]} preorder
 * @return {TreeNode}
 */
var bstFromPreorder = function(preorder) {
  if (preorder.length === 0) {
    return null;
  }

  var root = new TreeNode(preorder[0]);

  if (preorder.length > 1) {
    var firstIndexGreaterThanRoot = preorder.findIndex(item => item > root.val);
    if (firstIndexGreaterThanRoot > -1) {
      root.left = bstFromPreorder(preorder.slice(1, firstIndexGreaterThanRoot));
      root.right = bstFromPreorder(preorder.slice(firstIndexGreaterThanRoot));
    } else {
      root.left = bstFromPreorder(preorder.slice(1));
      root.right = null;
    }
  }

  return root;
};