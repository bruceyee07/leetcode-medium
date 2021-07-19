/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @description https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
 * @type self
 * @param {TreeNode} root
 * @return {number}
 */
var sumEvenGrandparent = function(root) {
  if (!root) {
    return 0;
  }
  var sum = 0;
  if (root.val % 2 === 0) {
    if (root.left && root.left.left) {
      sum += root.left.left.val;
    }
    if (root.left && root.left.right) {
      sum += root.left.right.val;
    }
    if (root.right && root.right.left) {
      sum += root.right.left.val;
    }
    if (root.right && root.right.right) {
      sum += root.right.right.val;
    }
  }
  return sum + sumEvenGrandparent(root.left) + sumEvenGrandparent(root.right);
};               