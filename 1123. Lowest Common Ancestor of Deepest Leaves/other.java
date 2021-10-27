/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
 * self
 */
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
 * https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
 * https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/discuss/334577/JavaC%2B%2BPython-Two-Recursive-Solution
 */
class Solution {
  public TreeNode lcaDeepestLeaves(TreeNode root) {
    Pair p = getLCA(root, 0);
    return (TreeNode)p.getKey();
  }

  private Pair<TreeNode, Integer> getLCA(TreeNode node, int depth) {
    if (node == null) return new Pair(null, depth);
    Pair left = getLCA(node.left, depth + 1);
    Pair right = getLCA(node.right, depth + 1);
    int leftDepth = (int)left.getValue();
    int rightDepth = (int)right.getValue();
    if (leftDepth == rightDepth) {
      return new Pair(node, leftDepth);
    }
    return leftDepth > rightDepth ? left : right;
  }
}

// Solution 1: Get Subtree Height and LCA
// helper function return the subtree height and lca and at the same time.
// null node will return depth 0,
// leaves will return depth 1.