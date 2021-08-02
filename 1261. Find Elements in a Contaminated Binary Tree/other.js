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
 * @tutorial https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/discuss/431107/JavaPython-3-DFS-and-BFS-clean-codes-w-analysis.
 * @param {TreeNode} root
 */
var FindElements = function(root) {
  this.seen = [];

  function dfs(root, seen, val) {
    if (!root) {
      return;
    }
    root.val = val;
    seen.push(val);
    dfs(root.left, seen, 2 * val + 1);
    dfs(root.right, seen, 2 * val + 2);
  }

  dfs(root, this.seen, 0);
};

/** 
 * @param {number} target
 * @return {boolean}
 */
FindElements.prototype.find = function(target) {
  return this.seen.includes(target);
};

/** 
 * Your FindElements object will be instantiated and called as such:
 * var obj = new FindElements(root)
 * var param_1 = obj.find(target)
 */