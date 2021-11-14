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
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * self
 */
class Solution {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) return ans;
    Queue<TreeNode> unvisited = new LinkedList<>();
    unvisited.offer(root);
    while (!unvisited.isEmpty()) {
      List<Integer> level = new ArrayList<>();
      int size = unvisited.size();
      for (int i = 0; i < size; i++) {
        TreeNode cur = unvisited.poll();;
        level.add(cur.val);
        if (cur.left != null) unvisited.offer(cur.left);
        if (cur.right != null) unvisited.offer(cur.right);
      }
      ans.add(level);
    }
    for (int i = 0; i < ans.size(); i++) {
      if (i % 2 != 0) {
        Collections.reverse(ans.get(i));
      }
    }
    return ans;
  }
}