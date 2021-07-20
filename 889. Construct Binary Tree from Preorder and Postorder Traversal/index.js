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
    var preorderExceptRoot = preorder.slice(1); // 前序遍历不包含根节点的部分
    var postorderExceptRoot = postorder.slice(0, -1); // 后序遍历不包含根节点的部分
    var leftPreorder = leftPostorder = rightPreorder = rightPostorder = [];

    function traverse(direction) {
      for (let i = 1; i <= preorderExceptRoot.length; i++) {
        if (preorderExceptRoot.slice(0, i).sort().toString() === postorderExceptRoot.slice(0, i).sort().toString()) {
          leftPreorder = preorderExceptRoot.slice(0, i);
          leftPostorder = postorderExceptRoot.slice(0, i);
  
          rightPreorder = preorderExceptRoot.slice(i);
          rightPostorder = postorderExceptRoot.slice(i);
  
          direction === 'left' ? 
            node.left = constructFromPrePost(leftPreorder, leftPostorder) :
            node.right = constructFromPrePost(rightPreorder, rightPostorder);
          break;
        }
      }
    }

    traverse('left');
    traverse('right');
  }

  return node;
};


// Your input
// [1,2,4,5,3,6,8,7]
// [4,5,2,8,6,7,3,1]

// Output
// [1,2,3,4,5,6,7,null,null,null,null,8]

// Expected
// [1,2,3,4,5,6,7,null,null,null,null,8]