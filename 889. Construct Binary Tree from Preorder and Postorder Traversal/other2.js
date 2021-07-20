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
 * @tutorial https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/discuss/161268/C%2B%2BJavaPython-One-Pass-Real-O(N)
 * @param {number[]} pre
 * @param {number[]} post
 * @return {TreeNode}
 */
var constructFromPrePost = function(pre, post) {
  let i = 0;
  
  return helper(post);
  
  function helper(post){
    if(post.length == 0) return null;
    let node = new TreeNode(pre[i++]);
    console.log('===== node1 ======', node);
    let index = post.indexOf(pre[i]);
    console.log('====== index ======', index);
    console.log('====== post 1 ======', post.slice(0, index + 1));
    node.left = helper(post.slice(0, index + 1));
    console.log('====== post 2 ======', post.slice(index + 1, post.indexOf(node.val)));
    node.right = helper(post.slice(index + 1, post.indexOf(node.val)));  
    return node;
  }
};


// Input: pre = [1,2,4,5,3,6,8,7], post = [4,5,2,8,6,7,3,1]
// Output: [1,2,3,4,5,6,7,null,null,null,null,null,null,8]

//          1
//     2         3
// 4     5    6      7
//                      8

// ===== node1 ====== [1]
// ====== index ====== 2
// ====== post 1 ====== [ 4, 5, 2 ]
// ===== node1 ====== [2]
// ====== index ====== 0
// ====== post 1 ====== [ 4 ]
// ===== node1 ====== [4]
// ====== index ====== -1
// ====== post 1 ====== []
// ====== post 2 ====== []
// ====== post 2 ====== [ 5 ]
// ===== node1 ====== [5]
// ====== index ====== -1
// ====== post 1 ====== []
// ====== post 2 ====== []
// ====== post 2 ====== [ 8, 6, 7, 3 ]
// ===== node1 ====== [3]
// ====== index ====== 1
// ====== post 1 ====== [ 8, 6 ]
// ===== node1 ====== [6]
// ====== index ====== 0
// ====== post 1 ====== [ 8 ]
// ===== node1 ====== [8]
// ====== index ====== -1
// ====== post 1 ====== []
// ====== post 2 ====== []
// ====== post 2 ====== []
// ====== post 2 ====== [ 7 ]
// ===== node1 ====== [7]
// ====== index ====== -1
// ====== post 1 ====== []
// ====== post 2 ====== []