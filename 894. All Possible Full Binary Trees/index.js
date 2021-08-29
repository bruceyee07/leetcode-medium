/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @description https://leetcode.com/problems/all-possible-full-binary-trees/
 * @type self
 * @param {number} n
 * @return {TreeNode[]}
 */
var allPossibleFBT = function(n) {
  var arr = [];

  constructFBT(n, arr);

  return arr;
};

function constructFBT(n, arr) {
  if (n <= 0) {
    return;
  }
  if (n === 1) {
    arr.push(new TreeNode(0));
  }

  var node = new TreeNode(0);

  for (let i = 1; i <= n - 2; i += 2) {
    node.left = constructFBT(i, arr);
    node.right = constructFBT(n - i - 1, arr);
    arr.push(node);
  }

  return node;
}

// function TreeNode(val, left, right) {
//   this.val = (val === undefined ? 0 : val);
//   this.left = (left === undefined ? null : left);
//   this.right = (right === undefined ? null : right);
// }


// 7

// [[0],[0],[0],[0],[0,0,0],[0,0,0,0,0],[0],[0],[0,0,0],[0],[0,0,0,0,0],[0,0,0,0,0,null,null,0,0],[0],[0],[0,0,0],[0],[0],[0,0,0],[0,0,0,0,0,null,null,0,0],[0],[0],[0],[0,0,0],[0,0,0,0,0],[0],[0],[0,0,0],[0],[0,0,0,0,0],[0],[0,0,0,0,0,null,null,0,0]]

// [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]

// 7 = root + 1 + 5 = root + 3 + 3 = root + 5 + 1