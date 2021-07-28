/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @description https://leetcode.com/problems/even-odd-tree/
 * @type self
 * @param {TreeNode} root
 * @return {boolean}
 */
var isEvenOddTree = function(root) {
  var levelOrderArr = levelOrder(root);

  for (let i = 0; i < levelOrderArr.length; i++) {
    if (i % 2 === 0) {
      if (!levelOrderArr[i].every(val => val % 2 !== 0) || !checkStrictAscendingOrDescending(levelOrderArr[i], 'a')) {
        return false;
      }
    } else {
      if (!levelOrderArr[i].every(val => val % 2 == 0) || !checkStrictAscendingOrDescending(levelOrderArr[i], 'd')) {
        return false;
      }
    }
  }

  return true;
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

function checkStrictAscendingOrDescending(arr, flag) {
  if (arr.length === 0) {
    return false;
  }
  if (arr.length === 1) {
    return true;
  }

  for (let i = 0; i < arr.length - 1; i++) {
    if (flag === 'a') { // 'chceck ascending'
      if (arr[i] >= arr[i + 1]) {
        return false;
      }
    } else {
      if (arr[i] <= arr[i + 1]) {
       return false;
      }
    }
  }
  return true;
}