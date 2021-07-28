/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * @description https://leetcode.com/problems/serialize-and-deserialize-bst/
 * @type self
 */
/**
 * Encodes a tree to a single string.
 *
 * @param {TreeNode} root
 * @return {string}
 */
var serialize = function(root) {
  return preorder(root).join(',');
};

/**
 * Decodes your encoded data to tree.
 *
 * @param {string} data
 * @return {TreeNode}
 */
var deserialize = function(data) {
  var preorderArr = data ? data.split(',').map(str => +str) : [];
  return bstFromPreorder(preorderArr);
};

/**
 * Your functions will be called as such:
 * deserialize(serialize(root));
 */

function preorder(root) {
  if (!root) {
    return [];
  }
  return [root.val].concat(preorder(root.left), preorder(root.right));
}

var bstFromPreorder = function(preorder) {
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