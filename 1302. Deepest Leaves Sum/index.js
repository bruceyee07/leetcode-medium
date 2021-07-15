/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @description https://leetcode.com/problems/deepest-leaves-sum/
 * @type self
 * @param {TreeNode} root
 * @return {number}
 */
var deepestLeavesSum = function(root) {
  var levelOrderRes = levelOrder(root);
  var deepestLeaves = levelOrderRes[levelOrderRes.length - 1];
  return deepestLeaves.reduce((prev, cur) => {
    return prev + cur;
  }, 0)
};

function levelOrder(root) {
  if (root === null) {
    return [];
  }
  var res = [];
  var unvisited = [root];

  while (unvisited.length) {
    res.push([]);
    var currentLevelSize = unvisited.length;

    for (let i = 1; i <= currentLevelSize; i++) {
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