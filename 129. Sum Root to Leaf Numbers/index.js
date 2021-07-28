/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @description https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * @type self
 * @param {TreeNode} root
 * @return {number}
 */
var sumNumbers = function(root) {
  var allRootToLeafPaths = binaryTreePaths(root);
  return allRootToLeafPaths.reduce((prev, cur) => Number(prev) + Number(cur), 0);
};

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @description https://leetcode.com/problems/binary-tree-paths/
 * @type self
 * @param {TreeNode} root
 * @return {string[]}
 */
function binaryTreePaths(root) {
  if (!root) {
    return [];
  }
  if (!root.left && !root.right) {
    return [`${root.val}`];
  }

  var arr = [];
  arr = arr.concat(binaryTreePaths(root.left).map(path => `${root.val}${path}`));
  arr = arr.concat(binaryTreePaths(root.right).map(path => `${root.val}${path}`));

  return arr;
};
