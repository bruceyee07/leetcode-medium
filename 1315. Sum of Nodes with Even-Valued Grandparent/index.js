/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @description https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
 * @type self
 * @param {TreeNode} root
 * @return {number}
 */
var sumEvenGrandparent = function(root) {
  var map = {};

  var preorderRes = preorder(root);
  preorderRes.forEach(node => helper(node, map));

  var arr = [];
  Object.keys(map).forEach(grandparentVal => {
    arr = arr.concat(map[grandparentVal]);
  });

  return arr.reduce((prev, cur) => prev + cur, 0);
};

function helper(root, map) {
  if (!root || (!root.left && !root.right) || root.val % 2 !== 0) {
    return;
  }

  if (root.left && root.left.left) {
    if (Array.isArray(map[root.val])) {
      map[root.val].push(root.left.left.val);
    } else {
      map[root.val] = [];
      map[root.val].push(root.left.left.val);
    }
  }
  if (root.left && root.left.right) {
    if (Array.isArray(map[root.val])) {
      map[root.val].push(root.left.right.val);
    } else {
      map[root.val] = [];
      map[root.val].push(root.left.right.val);
    }
  }
  if (root.right && root.right.left) {
    if (Array.isArray(map[root.val])) {
      map[root.val].push(root.right.left.val);
    } else {
      map[root.val] = [];
      map[root.val].push(root.right.left.val);
    }
  }
  if (root.right && root.right.right) {
    if (Array.isArray(map[root.val])) {
      map[root.val].push(root.right.right.val);
    } else {
      map[root.val] = [];
      map[root.val].push(root.right.right.val);
    }
  }
}

function preorder(root) {
  if (!root) {
    return [];
  }
  return [root].concat(preorder(root.left)).concat(preorder(root.right));
}                          