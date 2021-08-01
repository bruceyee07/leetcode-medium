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
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/solution/
 */

class Pair {
  public TreeNode node;
  public int maxSoFar;
  
  public Pair(TreeNode node, int maxSoFar) {
    this.node = node;
    this.maxSoFar = maxSoFar;
  }
}

class Solution {
  public int goodNodes(TreeNode root) {
    int numGoodNodes = 0;
    Stack<Pair> stack = new Stack<>();
    stack.push(new Pair(root, Integer.MIN_VALUE));
    
    while (stack.size() > 0) {
      Pair curr = stack.pop();
      if (curr.maxSoFar <= curr.node.val) {
        numGoodNodes++;
      }
      
      if (curr.node.left != null) {
        stack.push(new Pair(curr.node.left, Math.max(curr.node.val, curr.maxSoFar)));
      }
      
      if (curr.node.right != null) {
        stack.push(new Pair(curr.node.right, Math.max(curr.node.val, curr.maxSoFar)));
      }
    }

    return numGoodNodes;
  }
}

/**
 *
 * Approach 2: Depth First Search, Iterative
 * Intuition
 *
 * DFS can also be implemented iteratively. You may be thinking at this point: what kind of DFS should we use, preorder, postorder, or inorder? The answer is that, for this problem, it doesn't matter. For each node, there is only one path from the root to that node, so regardless of the order of our traversal, the integer we use to track the greatest value will always be the largest value between the current node and the root.
 *
 * The algorithm works the same as in the previous approach, but we will be using our own stack instead of recursion. We can implement the tracking integer by pairing the nodes with the integer when we push elements onto the stack. Depending on the language you're using, this might be done with a tuple or a custom object.
 *
 * Algorithm
 *
 * Initialize a stack to use for DFS, as well as a variable numGoodNodes that keeps track of how many good nodes are in the tree. The stack should initially contain the root and a very small value (like INT_MIN).
 *
 * Execute DFS: while the stack is not empty, pop from the stack.
 *
 * At each node, first check if node.val is greater than or equal to the number associated with it maxSoFar. If it is, then increment numGoodNodes. Next, push the children onto the stack, along with the greater value between maxSoFar and node.val.
 *
 * Return numGoodNodes.
 */