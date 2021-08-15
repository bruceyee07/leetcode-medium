/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @description https://leetcode.com/problems/check-completeness-of-a-binary-tree/
 * @type self
 * @param {TreeNode} root
 * @return {boolean}
 */
var isCompleteTree = function(root) {
  var levelOrderArr = levelorder(root);
  var levels = levelOrderArr.length;

  for (let i = 0; i < levels - 1; i++) {
    if (levelOrderArr[i].filter(Boolean).length !== 2 ** i) {
      return false;
    }
  }

  if (levelOrderArr[levels - 1].filter(Boolean).length === 2 ** (levels - 1)) {
    return true;
  }

  var firstNullIndex = levelOrderArr[levels - 1].findIndex(val => val === null);
  for (let i = firstNullIndex + 1; i < levelOrderArr[levels - 1].length; i++) {
    if (levelOrderArr[levels - 1][i] !== null) {
      return false;
    }
  }

  return true;
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

/**
 * last try...
 */