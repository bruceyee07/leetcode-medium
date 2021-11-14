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
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/discuss/33815/My-accepted-JAVA-solution @marcusgao
 */
class Solution {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) return ans;
    Queue<TreeNode> unvisited = new LinkedList<>();
    unvisited.add(root);
    boolean zigzag = false;
    while (!unvisited.isEmpty()) {
      List<Integer> level = new ArrayList<>();
      int size = unvisited.size();
      for (int i = 0; i < size; i++) {
        TreeNode cur = unvisited.poll();;
        if (zigzag) level.add(0, cur.val);
        else level.add(cur.val);
        if (cur.left != null) unvisited.add(cur.left);
        if (cur.right != null) unvisited.add(cur.right);
      }
      ans.add(level);
      zigzag = !zigzag;
    }
    return ans;
  }
}