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
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/er-cha-shu-de-ceng-xu-bian-li-by-leetcode-solution/
 */
class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) return ans;
    Queue<TreeNode> unvisited = new LinkedList<>();
    unvisited.offer(root);
    while (!unvisited.isEmpty()) {
      ans.add(new ArrayList<Integer>());
      int size = unvisited.size();
      for (int i = 0; i < size; i++) {
        TreeNode cur = unvisited.poll();
        ans.get(ans.size() - 1).add(cur.val);
        if (cur.left != null) unvisited.offer(cur.left);
        if (cur.right != null) unvisited.offer(cur.right);
      }
    }
    return ans;
  }
}
