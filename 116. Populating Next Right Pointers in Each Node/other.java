/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/discuss/37472/A-simple-accepted-solution @haoyangfan
 */
class Solution {
  public Node connect(Node root) {
    dfs(root, null);
    return root;
  }

  public void dfs(Node cur, Node next) {
    if (cur == null) return;
    cur.next = next;
    dfs(cur.left, cur.right);
    dfs(cur.right, cur.next == null ? null : cur.next.left);
  }
}