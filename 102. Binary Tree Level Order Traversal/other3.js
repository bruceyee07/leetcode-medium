/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * * @description https://leetcode.com/problems/binary-tree-level-order-traversal/
 * @tutorial 56ms sample solution
 * @param {TreeNode} root
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function (root) {
  if (!root) return [];
  const res = [],
    queue = [root];

  while (queue.length) {
    const curLayer = [];
    let length = queue.length;
    for (let i = 0; i < length; i++) {
      const curNode = queue.shift();
      curLayer.push(curNode.val);
      if (curNode.left) queue.push(curNode.left);
      if (curNode.right) queue.push(curNode.right);
    }
    res.push(curLayer);
  }
  return res;
};
