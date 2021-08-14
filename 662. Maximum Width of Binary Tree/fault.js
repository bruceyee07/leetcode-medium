/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @description https://leetcode.com/problems/maximum-width-of-binary-tree/
 * @type self
 * @param {TreeNode} root
 * @return {number}
 */
var widthOfBinaryTree = function(root) {
  var levelorderArr = levelorder(root);
  var max = -Infinity;
  for (let i = 0; i < levelorderArr.length; i++) {
    var level = levelorderArr[i];
    var start = level.findIndex(val => val !== null);
    var end = getLastIndexOfNonNull(level);
    var width = end - start + 1;
    if (width > max) {
      max = width;
    }
  }
  return max;
};

function levelorder(root) {
  var res = [];
  var unvisited = [root];
  var height = getTreeHeight(root);
  while (unvisited.length) {
    res.push([]);
    var currentLevelSize = unvisited.length;
    for (let i = 0; i < currentLevelSize; i++) {
      var node = unvisited.shift();
      res[res.length - 1].push(node ? node.val : null);
      if (node && node.left) {
        unvisited.push(node.left);
      } else if (res.length < height) {
        unvisited.push(null);
      }
      if (node && node.right) {
        unvisited.push(node.right);
      } else if (res.length < height) {
        unvisited.push(null);
      }
    }
  }
  return res;
}

function getTreeHeight(root) {
  if (!root) {
    return 0;
  }
  return Math.max(getTreeHeight(root.left), getTreeHeight(root.right)) + 1;
}

function getLastIndexOfNonNull(arr) {
  var index = arr.length;
  while (index-- && !arr[index]);
  return index;
}

/**
 * Time limit exceeded
 */