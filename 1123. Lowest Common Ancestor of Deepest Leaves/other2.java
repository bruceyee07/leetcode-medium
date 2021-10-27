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
 * https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/discuss/146808/C%2B%2BJavaPython-One-Pass
 */
class Solution {
  public TreeNode subtreeWithAllDeepest(TreeNode root) {
    Pair<TreeNode, Integer> p = getLCA(root, 0);
    return p.getKey();
  }

  private Pair<TreeNode, Integer> getLCA(TreeNode node, int depth) {
    if (node == null) return new Pair(null, depth);
    Pair<TreeNode, Integer> left = getLCA(node.left, depth + 1);
    Pair<TreeNode, Integer> right = getLCA(node.right, depth + 1);
    int leftDepth = left.getValue();
    int rightDepth = right.getValue();
    if (leftDepth == rightDepth) {
      return new Pair(node, leftDepth);
    }
    return leftDepth > rightDepth ? left : right;
  }
}

Explanatoin
Write a sub function deep(TreeNode root).
Return a pair(int depth, TreeNode subtreeWithAllDeepest)

In sub function deep(TreeNode root):

if root == null,
return pair(0, null)

if left depth == right depth,
deepest nodes both in the left and right subtree,
return pair (left.depth + 1, root)

if left depth > right depth,
deepest nodes only in the left subtree,
return pair (left.depth + 1, left subtree)

if left depth < right depth,
deepest nodes only in the right subtree,
return pair (right.depth + 1, right subtree)


Complexity
Time O(N)
Space O(height)