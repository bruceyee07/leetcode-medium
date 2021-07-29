/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @description https://leetcode.com/problems/count-complete-tree-nodes/
 * @tutorial https://leetcode.com/problems/count-complete-tree-nodes/discuss/61958/Concise-Java-solutions-O(log(n)2)
 * @param {TreeNode} root
 * @return {number}
 */
var countNodes = function(root) {
  var h = getHeightOfCompleteTree(root);
  return h < 0 ? 0 : getHeightOfCompleteTree(root.right) === h - 1 ? (1 << h) + countNodes(root.right) : (1 << h - 1) + countNodes(root.left);
};

function getHeightOfCompleteTree(root) {
  return root === null ? -1 : 1 + getHeightOfCompleteTree(root.left);
}