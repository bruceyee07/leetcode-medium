/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @description https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 * @tutorial https://leetcode.com/problems/count-good-nodes-in-binary-tree/submissions/
 * @param {TreeNode} root
 * @return {number}
 */
var goodNodes = function(root) {
  var count = 0;
  dfs(root, -Infinity);

  function dfs(node, maxSoFar) {
    if (maxSoFar <= node.val) {
      count++;
    }
    if (node.left) {
      dfs(node.left, Math.max(node.val, maxSoFar));
    }
    if (node.right) {
      dfs(node.right, Math.max(node.val, maxSoFar));
    }
  }

  return count;
}