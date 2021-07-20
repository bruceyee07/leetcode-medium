/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @description https://leetcode.com/problems/maximum-binary-tree/
 * @type self
 * @param {number[]} nums
 * @return {TreeNode}
 */
var constructMaximumBinaryTree = function(nums) {
  if (!nums.length) {
    return null;
  }
  var maxValue = Math.max(...nums);
  var maxIndex = nums.findIndex(val => val === maxValue);
  var left = nums.slice(0, maxIndex);
  var right = nums.slice(maxIndex + 1);

  var node = new TreeNode(maxValue);
  node.left = constructMaximumBinaryTree(left);
  node.right = constructMaximumBinaryTree(right);
  
  return node;
};