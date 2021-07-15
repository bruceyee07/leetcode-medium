/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 /**
  * description https://leetcode.com/problems/deepest-leaves-sum/
  * https://leetcode.com/problems/deepest-leaves-sum/discuss/463239/JavaC%2B%2BPython-Level-Traversal
  */
class Solution {
  public int deepestLeavesSum(TreeNode root) {
    int res = 0, i;
    LinkedList<TreeNode> q = new LinkedList<TreeNode>();
    q.add(root);
    while (!q.isEmpty()) {
      // res = 0 represents starting a new level
      for (i = q.size() - 1, res = 0; i >= 0; --i) {
        TreeNode node = q.poll();
        res += node.val;
        if (node.left != null) q.add(node.left);
        if (node.right  != null) q.add(node.right);
      }
    }
    return res;
  }
}