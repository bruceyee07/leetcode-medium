/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @description https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * @type self
 * @param {number[]} inorder
 * @param {number[]} postorder
 * @return {TreeNode}
 */
var buildTree = function(inorder, postorder) {
  if (postorder.length === 0 && inorder.length === 0) {
    return null;
  }

  var postorderLength = postorder.length;
  var rootValue = postorder[postorderLength - 1];
  var node = new TreeNode(rootValue);

  if (postorderLength > 1) {
    var rootValIndexOfInorder = inorder.findIndex(val => val === rootValue);
    var leftOfInorder = rootValIndexOfInorder > -1 ? inorder.slice(0, rootValIndexOfInorder) : [];
    var rightOfInorder = rootValIndexOfInorder + 1 > inorder.length - 1 ? [] : inorder.slice(rootValIndexOfInorder + 1);

    var firstIndexOfRightInPostorder = postorder.findIndex(val => rightOfInorder.includes(val));
    var leftOfPostorder = firstIndexOfRightInPostorder > -1 ? postorder.slice(0, firstIndexOfRightInPostorder) : postorder.slice(0, postorderLength - 1);
    var rightOfPostorder = firstIndexOfRightInPostorder > -1 ? postorder.slice(firstIndexOfRightInPostorder, postorderLength - 1) : [];

    node.left = buildTree(leftOfInorder, leftOfPostorder);
    node.right = buildTree(rightOfInorder, rightOfPostorder);
  }

  return node;
};

// [9,  3,     15,20,7]
// [9,   15,7,20,   3]
// [3,9,20,null,null,15,7]


//    3
// 9     20   
//    15      7


// [2,     1, ......]
// [2,     1]
// expected: [1,2]



// Input:
// [2,1]
// [2,1]
// Output:
// [1,0]
// Expected:
// [1,2]