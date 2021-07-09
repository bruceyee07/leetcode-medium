/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @description https://leetcode.com/problems/binary-tree-level-order-traversal/
 * @tutorial https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/er-cha-shu-de-ceng-xu-bian-li-by-leetcode-solution/
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function (root) {
  if (!root) {
    return [];
  }
  const res = [];
  const unvisted = [];
  unvisted.push(root);

  while (unvisted.length > 0) {
    res.push([]);

    const currentLevelSize = unvisted.length;
    for (let i = 1; i <= currentLevelSize; i++) {
      const node = unvisted.shift();
      res[res.length - 1].push(node.val);

      if (node.left) {
        unvisted.push(node.left);
      }

      if (node.right) {
        unvisted.push(node.right);
      }
    }
  }
  return res;
};
