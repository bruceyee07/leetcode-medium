/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @description https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 * @type self
 * @param {TreeNode} root
 * @return {number[]}
 */
var largestValues = function(root) {
  var levelOrderRes = levelOrder(root);
  return levelOrderRes.map(level => Math.max(...level));
};

function levelOrder(root) {
  if (!root) {
    return [];
  }

  var res = [];
  var unvisited = [root];
  while (unvisited.length) {
    res.push([]);
    var currentLevelSize = unvisited.length;
    for (let i = 0; i < currentLevelSize; i++) {
      var node = unvisited.shift();
      res[res.length - 1].push(node.val);
      if (node.left) {
        unvisited.push(node.left);
      }
      if (node.right) {
        unvisited.push(node.right);
      }
    }
  }

  return res;
}