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
 * https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
 * https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/discuss/477095/Easy-DFS-solution
 */
class Solution {
  public int sum = 0;

  public int sumEvenGrandparent(TreeNode root) {
    dfs(root, null, null);
    return sum;
  }

  void dfs(TreeNode current, TreeNode parent, TreeNode grandParent) {
    if (current == null) return;
    if (grandParent != null && grandParent.val % 2 == 0) {
      sum += current.val;
    }
    dfs(current.left, current, parent);
    dfs(current.right, current, parent);
  }
}

/**
 * I'm confused that why told me it's a wrong answer when submitted, whereas the test case passed
 * test case: [50,null,54,98,6,null,null,null,34]
 * expected: 138
 * output: 156
 */

/**
 * here's the reason: https://support.leetcode.com/hc/en-us/articles/360011834174-I-encountered-Wrong-Answer-Runtime-Error-for-a-specific-test-case-When-I-test-my-code-using-this-test-case-it-produced-the-correct-output-Why-
 * remove the static keyword, then it worked.
 */