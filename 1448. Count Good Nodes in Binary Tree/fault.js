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
 * @type self
 * @param {TreeNode} root
 * @return {number}
 */
var goodNodes = function(root) {
  if (!root) {
    return 0;
  }
  if (!root.left && !root.right) {
    return 1;
  }
  var paths = findAllPaths(root);
  var ans = 1;
  for (let i = 0; i  < paths.length; i++) {
    var curPathExceptRoot = paths[i].slice(1);
    ans += curPathExceptRoot.filter(val => val >= Math.max(...paths[i])).length;
  }
  return ans;
};

function findAllPaths(root) {
  if (!root) {
    return [];
  }
  if (!root.left && !root.right) {
    return [root.val];
  }
  var arr = [];
  arr = arr.concat(findAllPaths(root.left).map(subpath => [root.val].concat(subpath)));
  arr = arr.concat(findAllPaths(root.right).map(subpath => [root.val].concat(subpath)));
  return arr;
}