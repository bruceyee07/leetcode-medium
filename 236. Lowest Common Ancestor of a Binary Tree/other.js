/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @description https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * @tutorial https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/discuss/65225/4-lines-C%2B%2BJavaPythonRuby
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor = function(root, p, q) {
  if (!root || root === p || root === q) {
    return root;
  }

  var left = lowestCommonAncestor(root.left, p, q);
  var right = lowestCommonAncestor(root.right, p, q);

  return left === null ? right : right === null ? left : root;
};

/**
 * 从本解法跟 sample 解法的对比来看，无非就是三元表达式和 if/else 的区别，感觉理论上应该没什么效率上的差别
 */