/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @description https://leetcode.com/problems/recover-binary-search-tree/
 * @type self
 * @param {TreeNode} root
 * @return {void} Do not return anything, modify root in-place instead.
 */
var recoverTree = function(root) {
  var wrongInorder = inorder(root);
  var wrongPreorder = preorder(root);
  var correctInorder = wrongInorder.concat([]).sort((a, b) => a - b); // 这里 concat 实现深拷贝，因为 sort 是原地排序，会影响原始数组

  var swapIndexs = [];
  for (let i = 0; i < wrongInorder.length; i++) {
    if (swapIndexs.length == 2) {
      break;
    }
    if (wrongInorder[i] !== correctInorder[i]) {
      swapIndexs.push(i);
    }
  }

  var temp = wrongPreorder[swapIndexs[1]];
  wrongPreorder[swapIndexs[1]] = wrongPreorder[swapIndexs[0]];
  wrongPreorder[swapIndexs[0]] = temp;

  return bstFromPreorder(wrongPreorder);
};

function inorder(root) {
  if (root === null) {
    return [];
  }
  return inorder(root.left).concat([root.val], inorder(root.right));
};

function preorder(root) {
  if (!root) {
    return [];
  }
  return [root.val].concat(preorder(root.left), preorder(root.right));
}

function bstFromPreorder(preorder) {
  if (preorder.length === 0) {
    return null;
  }

  var root = new TreeNode(preorder[0]);

  if (preorder.length > 1) {
    var firstIndexGreaterThanRoot = preorder.findIndex(item => item > root.val);
    if (firstIndexGreaterThanRoot > -1) {
      root.left = bstFromPreorder(preorder.slice(1, firstIndexGreaterThanRoot));
      root.right = bstFromPreorder(preorder.slice(firstIndexGreaterThanRoot));
    } else {
      root.left = bstFromPreorder(preorder.slice(1));
      root.right = null;
    }
  }

  return root;
};