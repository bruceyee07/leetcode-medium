/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @description https://leetcode.com/problems/delete-node-in-a-bst/
 * @type self
 * @param {TreeNode} root
 * @param {number} key
 * @return {TreeNode}
 */
var deleteNode = function(root, key) {
  var preorderArr = preorder(root);
  var keyIndex = preorderArr.findIndex(val => val === key);
  if (keyIndex > -1) {
    preorderArr.splice(keyIndex, 1);
    return bstFromPreorder(preorderArr);
  } else {
    return root;
  }
};

function preorder(root) {
  if (!root) {
    return [];
  }
  return preorder(root.left).concat([root.val], preorder(root.right));
}

function bstFromPreorder(arr) {
  if (!arr.length) {
    return null;
  }
  var midIndex = Math.floor(arr.length / 2);
  var root = new TreeNode(arr[midIndex]);
  root.left = bstFromPreorder(arr.slice(0, midIndex));
  root.right = bstFromPreorder(arr.slice(midIndex + 1));
  return root;
}