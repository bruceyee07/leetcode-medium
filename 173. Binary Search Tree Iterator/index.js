/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @description https://leetcode.com/problems/binary-search-tree-iterator/
 * @type self
 * @param {TreeNode} root
 */
var BSTIterator = function(root) {
  this.index = 0;
  this.inorderArr = inorder(root);
};

/**
 * @return {number}
 */
BSTIterator.prototype.next = function() {
  return this.inorderArr[this.index++];
};

/**
 * @return {boolean}
 */
BSTIterator.prototype.hasNext = function() {
  return this.index < this.inorderArr.length;
};

function inorder(root) {
  if (!root) {
    return [];
  }
  return inorder(root.left).concat([root.val], inorder(root.right));
}

/** 
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = new BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */