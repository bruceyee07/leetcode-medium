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
 * https://leetcode.com/problems/balance-a-binary-search-tree/
 * https://leetcode.com/problems/balance-a-binary-search-tree/discuss/539686/JavaC%2B%2B-Sorted-Array-to-BST-O(N)-Clean-code
 * self
 */
class Solution {
  public TreeNode balanceBST(TreeNode root) {
    List<TreeNode> sortedArray = inorder(root);
    return sortedArrayToBST(sortedArray);
  }

  public List<TreeNode> inorder(TreeNode root) {
    List<TreeNode> ans = new ArrayList<>();
    if (root == null) return ans;
    ans.addAll(inorder(root.left));
    ans.add(root);
    ans.addAll(inorder(root.right));
    return ans;
  }

  public TreeNode sortedArrayToBST(List<TreeNode> list) {
    if (list.size() == 0) return null;
    int start = 0, end = list.size() - 1;
    int mid = start + (end - start) / 2;
    TreeNode root = list.get(mid);
    root.left = sortedArrayToBST(list.subList(0, mid));
    root.right = sortedArrayToBST(list.subList(mid + 1, list.size()));
    return root;
  }
}