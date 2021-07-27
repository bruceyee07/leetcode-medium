/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @description https://leetcode.com/problems/trim-a-binary-search-tree/
 * @type self
 * @param {TreeNode} root
 * @param {number} low
 * @param {number} high
 * @return {TreeNode}
 */
var trimBST = function(root, low, high) {
  if (!root) {
    return null;
  }

  if (root.val < low) {
    if (root.right) {
      return trimBST(root.right, low, high);
    } else {
      return null;
    }
  }

  if (root.val > high) {
    if (root.left) {
      return trimBST(root.left, low, high);
    } else {
      return null;
    }
  }

  var node = new TreeNode(root.val);

  if (root.val === low) {
    node.right = trimBST(root.right, low, high);
  }

  if (node.val === high) {
    node.left = trimBST(root.left, low, high);
  }

  if (node.val > low && node.val < high) {
    node.left = trimBST(root.left, low, high);
    node.right = trimBST(root.right, low, high);
  }

  return node;
};