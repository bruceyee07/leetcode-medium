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
 * https://leetcode.com/problems/all-possible-full-binary-trees/
 * https://leetcode.com/problems/all-possible-full-binary-trees/solution/
 */
class Solution {
  Map<Integer, List<TreeNode>> memo = new HashMap();

	public List<TreeNode> allPossibleFBT(int n) { 
    if (!memo.containsKey(n)) {
      List<TreeNode> ans = new LinkedList();
      if (n == 1) {
        ans.add(new TreeNode(0));
      } else if (n % 2 == 1) {
        for (int x = 0; x < n; x++) {
          int y = n - 1 - x;
          for (TreeNode left : allPossibleFBT(x)) {
            for (TreeNode right : allPossibleFBT(y)) {
              TreeNode node = new TreeNode(0);
              node.left = left;
              node.right = right;
              ans.add(node);
            }
          }
        }
      }
      memo.put(n, ans);
    }

    return memo.get(n);
	}
}