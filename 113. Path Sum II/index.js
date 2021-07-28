/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @description https://leetcode.com/problems/path-sum-ii/
 * @type self
 * @param {TreeNode} root
 * @param {number} targetSum
 * @return {number[][]}
 */
var pathSum = function(root, targetSum) {
  return binaryTreePaths(root)
    .map(path => path.split(',')
    .map(str => +str))
    .filter(path => path.reduce((prev, cur) => prev + cur, 0) === targetSum);
};

function binaryTreePaths(root) {
  if (!root) {
    return [];
  }
  if (!root.left && !root.right) {
    return [`${root.val}`];
  }

  var arr = [];
  arr = arr.concat(binaryTreePaths(root.left).map(path => `${root.val},${path}`));
  arr = arr.concat(binaryTreePaths(root.right).map(path => `${root.val},${path}`));

  return arr;
};