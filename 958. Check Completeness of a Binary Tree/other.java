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
 * https://leetcode.com/problems/check-completeness-of-a-binary-tree/
 * https://leetcode.com/problems/check-completeness-of-a-binary-tree/discuss/205682/JavaC%2B%2BPython-BFS-Solution-and-DFS-Soluiton
 */
class Solution {
  public boolean isCompleteTree(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    while (queue.peek() != null) {
      TreeNode node = queue.poll();
      queue.offer(node.left);
      queue.offer(node.right);
    }
    while (!queue.isEmpty() && queue.peek() == null) {
      queue.poll();
    }
    return queue.isEmpty();
  }
}