/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @description https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 * @tutorial https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/discuss/161268/C%2B%2BJavaPython-One-Pass-Real-O(N)
 * @param {number[]} pre
 * @param {number[]} post
 * @return {TreeNode}
 */
var constructFromPrePost = function(preorder, postorder) {
  var preIndex = postIndex = 0;
  
  function traverse(order1, order2) {
    var node = new TreeNode(order1[preIndex++]);
    if (node.val !== order2[postIndex]) {
      node.left = traverse(order1, order2);
    }
    if (node.val !== order2[postIndex]) {
      node.right = traverse(order1, order2);
    }
    postIndex++;
    return node;
  }
  return traverse(preorder, postorder);
};