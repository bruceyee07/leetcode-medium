/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @description https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 * @type self
 * @param {number[]} pre
 * @param {number[]} post
 * @return {TreeNode}
 */
var constructFromPrePost = function(preorder, postorder) {
  if (preorder.length === 0 && postorder.length === 0) {
    return null;
  }

  var node = new TreeNode(preorder[0]);

  if (preorder.length > 1) {
    var leftRightOfPreorder = preorder.slice(1); // 前序遍历不包含根节点的部分
    var leftRightOfPostorder = postorder.slice(0, -1); // 后序遍历不包含根节点的部分
    var leftOfPreorder = leftOfPostorder = rightOfPreorder = rightOfPostorder = []; 


    console.log('======= leftRightOfPreorder ========', leftRightOfPreorder);
    console.log('======= leftRightOfPostorder ========', leftRightOfPostorder);

    for (let i = 0; i <= leftRightOfPreorder.length; i++) {
      if (leftRightOfPreorder.slice(0, i + 1).sort().toString() === leftRightOfPostorder.slice(0, i + 1).sort().toString()) {
        leftOfPreorder = leftRightOfPreorder.slice(0, i + 1);
        leftOfPostorder = leftRightOfPostorder.slice(0, i + 1);

        console.log('======= ************** i **************** ========', i);

        console.log('======= leftOfPreorder ========', leftOfPreorder);
        console.log('======= leftOfPostorder ========', leftOfPostorder);

        rightOfPreorder = leftRightOfPreorder.slice(i + 1);
        rightOfPostorder = leftRightOfPostorder.slice(i + 1);

        console.log('======= rightOfPreorder ========', rightOfPreorder);
        console.log('======= rightOfPostorder ========', rightOfPostorder);
        break;
      }
    }

    node.left = constructFromPrePost(leftOfPreorder, leftOfPostorder);
    node.right = constructFromPrePost(rightOfPreorder, rightOfPostorder);
  }

  return node;
};


// Input: pre = [1,2,4,5,3,6,8,7], post = [4,5,2,8,6,7,3,1]
// Output: [1,2,3,4,5,6,7,null,null,null,null,null,null,8]

//          1
//     2         3
// 4     5    6      7
//                      8

// 2,4,5,   3,6,8,7
// 4,5,2,   8,6,7,3

// stdout
// ======= leftRightOfPreorder ======== [
//   2, 4, 5, 3,
//   6, 8, 7
// ]
// ======= leftRightOfPostorder ======== [
//   4, 5, 2, 8,
//   6, 7, 3
// ]
// ======= ************** i **************** ======== 2
// ======= leftOfPreorder ======== [ 2, 4, 5 ]
// ======= leftOfPostorder ======== [ 4, 5, 2 ]
// ======= rightOfPreorder ======== [ 3, 6, 8, 7 ]
// ======= rightOfPostorder ======== [ 8, 6, 7, 3 ]
// ======= leftRightOfPreorder ======== [ 4, 5 ]
// ======= leftRightOfPostorder ======== [ 4, 5 ]
// ======= ************** i **************** ======== 0
// ======= leftOfPreorder ======== [ 4 ]
// ======= leftOfPostorder ======== [ 4 ]
// ======= rightOfPreorder ======== [ 5 ]
// ======= rightOfPostorder ======== [ 5 ]