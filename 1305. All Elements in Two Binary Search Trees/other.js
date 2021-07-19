/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @description https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
 * @tutorial https://leetcode.com/problems/all-elements-in-two-binary-search-trees/discuss/463852/JavaPython-3-2-codes%3A-O(n)-time-w-analysis.
 * @param {TreeNode} root1
 * @param {TreeNode} root2
 * @return {number[]}
 */
var getAllElements = function(root1, root2) {
  var ans = [];
  inorder(root1, ans);
  inorder(root2, ans);
  return ans.sort((a, b) => a - b);
};

function inorder(root, arr) {
  if (!root) {
    return;
  }
  inorder(root.left, arr);
  arr.push(root.val);
  inorder(root.right, arr);
}