/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @description https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @type self
 * @param {number[]} preorder
 * @param {number[]} inorder
 * @return {TreeNode}
 */
var buildTree = function(preorder, inorder) {
  if (preorder.length === 0 && inorder.length === 0) {
    return null;
  }

  var node = new TreeNode(preorder[0]);

  if (preorder.length > 1) {
    var rootValIndexOfInorder = inorder.findIndex(val => val === preorder[0]);
    var leftOfInorder = rootValIndexOfInorder > -1 ? inorder.slice(0, rootValIndexOfInorder) : [];
    var rightOfInorder = inorder.slice(rootValIndexOfInorder + 1);

    var firstIndexOfRightInPreorder = preorder.findIndex(val => rightOfInorder.includes(val));
    var leftOfPreorder = firstIndexOfRightInPreorder > -1 ? preorder.slice(1, firstIndexOfRightInPreorder) : preorder.slice(1);
    var rightOfPreorder = firstIndexOfRightInPreorder > -1 ? preorder.slice(firstIndexOfRightInPreorder) : [];

    node.left = buildTree(leftOfPreorder, leftOfInorder);
    node.right = buildTree(rightOfPreorder, rightOfInorder);
  }

  return node;
};