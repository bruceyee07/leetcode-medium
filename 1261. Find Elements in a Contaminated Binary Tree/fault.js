/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @description https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/
 * @type self
 * @param {TreeNode} root
 */
var FindElements = function(root) {
  this.root = root;
  this.root.val = 0;

  function traverse(node) {
    if (!node) {
      return;
    }
    if (node.left) {
      node.left.val = 2 * node.val + 1;
    }
    if (node.right) {
      node.right.val = 2 * node.val + 2;
    }
    traverse(node.left);
    traverse(node.right);
  }

  traverse(this.root);
};

/** 
 * @param {number} target
 * @return {boolean}
 */
FindElements.prototype.find = function(target) {
  return preorder(this.root).includes(target);
};

/** 
 * Your FindElements object will be instantiated and called as such:
 * var obj = new FindElements(root)
 * var param_1 = obj.find(target)
 */

function preorder(root) {
  if (!root) {
    return [];
  }
  return [root.val].concat(preorder(root.left), preorder(root.right));
}
/**
 * 28 / 31 test cases passee
 * this solution is time limit exceeded
 */