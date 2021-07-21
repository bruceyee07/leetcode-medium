/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @description https://leetcode.com/problems/balance-a-binary-search-tree/
 * @type self
 * @param {TreeNode} root
 * @return {TreeNode}
 */
var balanceBST = function(root) {
  var inorderRes = inorder(root);
  var midIndex = Math.floor(inorderRes.length / 2);
  var node = new TreeNode(inorderRes[midIndex]);

  node.left = bstFromAscendingArray(inorderRes.slice(0, midIndex), 'left');
  node.right = bstFromAscendingArray(inorderRes.slice(midIndex + 1), 'right');

  return node;
};

function inorder(root) {
  if (!root) {
    return [];
  }
  return inorder(root.left).concat([root.val], inorder(root.right));
}

function bstFromAscendingArray(arr, direction) {
  if (!arr.length) {
    return null;
  }
  var root;
  var dummy = new TreeNode(-1);

  if (direction === 'left') {
    root = new TreeNode(arr[arr.length - 1]);
    dummy.left = root;
    for (let i = arr.length - 2; i >= 0; i--) {
      root.left = new TreeNode(arr[i]);
      root.right = null;
      root = root.left;
    }
    return dummy.left;
  } else {
    root = new TreeNode(arr[0]);
    dummy.right = root;
    for (let i = 1; i < arr.length; i++) {
      root.right = new TreeNode(arr[i]);
      root.left = null;
      root = root.right;
    }
    return dummy.right;
  }
}

// Input
// [1,null,15,14,17,7,null,null,null,2,12,null,3,9,null,null,null,null,11]

// Output
// [11,9,12,7,null,null,14,3,null,null,15,2,null,null,17,1]

// Expected
// [9,2,14,1,3,11,15,null,null,null,7,null,12,null,17]