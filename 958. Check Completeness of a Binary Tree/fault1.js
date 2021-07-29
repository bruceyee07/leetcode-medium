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
  var levelOrderArr = levelOrderVariant(root);
  var levels = levelOrderArr.length;
  for (let i = 0; i < levels - 1; i++) {
    if (levelOrderArr[i].length !== 2 ** i) {
      return false;
    }
  }
  if (levelOrderArr[levels - 1].filter(Boolean).length === 2 ** (levels - 1)) {
    return true;
  }

  var lastLevelNullNodeIndexs = levelOrderArr[levels - 1].map((val, index) => {
    if (val === null) {
      return index;
    }
  }).filter(Boolean); // 第一次 wrong answer：注意这里不能用 filter(Boolean)，因为有可能包含索引 0

  if (lastLevelNullNodeIndexs.some(index => index % 2 === 0)) {
    return false;
  }

  return true;
};

/**
 * 层序遍历的变体：主要是为了能将空节点也能打印出来
 * 举个例子，对于 [1,2,3,4,5,null,7]，希望能打印出
 * [ [ 1 ], [ 2, 3 ], [ 4, 5, null, 7 ] ]
 * 传统的层序遍历只能打印出
 * [ [ 1 ], [ 2, 3 ], [ 4, 5, 7 ] ]
 * 这样你就不能确定这个 7 到底是靠左的节点还是靠右的节点了
 */
function levelOrderVariant(root) {
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
      res[res.length - 1].push(node ? node.val : null);
      if (node && node.left) {
        unvisited.push(node.left);
      } else if (node && node.right) { // 为了防止 node 是叶子节点
        unvisited.push(null);
      }

      if (node && node.right) {
        unvisited.push(node.right);
      } else if (node && node.left) {
        unvisited.push(null);
      }
    }
  }

  return res;
}

  /**
   * Input:[1,null,2]
   * Output:true
   * Expected:false
   */