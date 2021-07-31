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
      maxSoFar = node.val;
    }
    if (node.left) {
      dfs(node.left, maxSoFar);
    }
    if (node.right) {
      dfs(node.right,maxSoFar);
    }
  }

  return count;
}

/**
 * try to enhance the perf of other.js
 */