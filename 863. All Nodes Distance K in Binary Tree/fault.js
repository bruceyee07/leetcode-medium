/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @description https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 * @type self
 * @param {TreeNode} root
 * @param {TreeNode} target
 * @param {number} k
 * @return {number[]}
 */
var distanceK = function(root, target, k) {
  var levelorderArr = levelorder(root);
  var targetArr = levelorderArr.find(arr => arr.map(item => item.node.val).includes(target.val));
  var targetLevel = levelorderArr.findIndex(arr => arr.map(item => item.node.val).includes(target.val));
  var targetType = targetArr.find(item => item.node.val === target.val).type;
  
  if (targetType === 'root') {
    return levelorderArr[k].map(item => item.node.val);
  }
  if (targetType === 'left') {
    if (targetLevel < k) {
      return (levelorderArr[targetLevel - k] || []).filter(item => item.type === 'left').map(item => item.node.val)
        .concat(levelorderArr[targetLevel + k].filter(item => item.type === 'left').map(item => item.node.val))
        .concat(levelorderArr[k - targetLevel].filter(item => item.type === 'right').map(item => item.node.val));
    } else {
      return (levelorderArr[targetLevel - k] || []).filter(item => item.type === 'left').map(item => item.node.val)
        .concat(levelorderArr[targetLevel + k].filter(item => item.type === 'left').map(item => item.node.val));
    }
  }
  if (targetType === 'right') {
    if (targetLevel < k) {
      return (levelorderArr[targetLevel - k] || []).filter(item => item.type === 'right').map(item => item.node.val)
        .concat(levelorderArr[targetLevel + k].filter(item => item.type === 'right').map(item => item.node.val))
        .concat(levelorderArr[k - targetLevel].filter(item => item.type === 'left').map(item => item.node.val));
    } else {
      return (levelorderArr[targetLevel - k] || []).filter(item => item.type === 'right').map(item => item.node.val)
        .concat(levelorderArr[targetLevel + k].filter(item => item.type === 'right').map(item => item.node.val));
    }
  }
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