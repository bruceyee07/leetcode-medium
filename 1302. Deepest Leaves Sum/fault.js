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
 * @tutorial https://leetcode.com/problems/deepest-leaves-sum/discuss/463239/JavaC%2B%2BPython-Level-Traversal
 * @param {TreeNode} root
 * @return {number}
 */
var deepestLeavesSum = function(root) {
  if (!root) {
    return 0;
  }
  var res = 0, i;
  var unvisited = [root];

  while (unvisited.length > 0) {
    var currentLevelSize = unvisited.length;
    for (i = currentLevelSize.length - 1, res = 0; i >= 0; --i) {
      var node = unvisited.shift();
      res += node.val;
      if (node.left) {
        unvisited.push(node.left);
      }
      if (node.right) {
        unvisited.push(node.right);
      }
    }
  }

  return res;
};

/**
 * Time Limit Exceeded
 */