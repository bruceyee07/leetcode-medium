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
 * https://leetcode.com/problems/delete-nodes-and-return-forest/
 * https://leetcode.com/problems/delete-nodes-and-return-forest/discuss/328853/JavaC%2B%2BPython-Recursion-Solution
 */
class Solution {
  List<TreeNode> ans;
  Set<Integer> to_delete_set;

  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    ans = new ArrayList<>();
    to_delete_set = new HashSet<>();
    for (int val : to_delete) {
      to_delete_set.add(val);
    }
    dfs(root, true);
    return ans;
  }

  private TreeNode dfs(TreeNode node, boolean is_root) {
    if (node == null) return null;
    boolean deleted = to_delete_set.contains(node.val);
    if (is_root && !deleted) ans.add(node);
    node.left = dfs(node.left, deleted);
    node.right = dfs(node.right, deleted);
    return deleted ? null : node;
  }
}