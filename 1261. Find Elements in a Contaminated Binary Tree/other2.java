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
 * https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/
 * https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/discuss/431107/JavaPython-3-DFS-and-BFS-clean-codes-w-analysis.
 */
class FindElements {
  private Set<Integer> seen = new HashSet<>();
    
  public FindElements(TreeNode root) {
    if (root != null) {
      root.val = 0;
      seen.add(root.val);
      bfs(root);
    }
  }
  
  private void bfs(TreeNode n) {
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(n);
    while (!q.isEmpty()) {
      TreeNode cur = q.poll();
      if (cur.left != null) {
        cur.left.val = 2 * cur.val + 1;
        q.offer(cur.left);
        seen.add(cur.left.val);
      }
      if (cur.right != null) {
        cur.right.val = 2 * cur.val + 2;
        q.offer(cur.right);
        seen.add(cur.right.val);
      }
    }
  }

  public boolean find(int target) {
    return seen.contains(target);
  }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */