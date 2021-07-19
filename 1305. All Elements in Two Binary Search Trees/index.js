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
 * @type self
 * @param {TreeNode} root1
 * @param {TreeNode} root2
 * @return {number[]}
 */
var getAllElements = function(root1, root2) {
  var arr1 = inorder(root1);
  var arr2 = inorder(root2);
  return merge(arr1, arr2);
};

function inorder(root) {
  if (!root) {
    return [];
  }
  return inorder(root.left).concat([root.val]).concat(inorder(root.right));
}

function merge(arr1, arr2) {
  var arr = [];

  while (arr1.length && arr2.length) {
    if (arr1[0] <= arr2[0]) {
      arr.push(arr1.shift());
    } else {
      arr.push(arr2.shift());
    }
  }

  arr = arr.concat(arr1).concat(arr2);

  return arr;
}