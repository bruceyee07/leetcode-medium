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
    Queue<TreeNode> bfs = new LinkedList<TreeNode>();
    bfs.offer(root);
    while (true) {
      TreeNode node = bfs.poll();
      if (node.left == null) {
        if (node.right != null) {
          return false;
        }
        break;
      }
      bfs.offer(node.left);
      if (node.right == null) break;
      bfs.offer(node.right);
    }
    while (!bfs.isEmpty()) {
      TreeNode node = bfs.poll();
      if (node.left != null || node.right != null) {
        return false;
      }
    }
    return true;
  }
}

/**
 * To be honest, I don't understand this solution
 */