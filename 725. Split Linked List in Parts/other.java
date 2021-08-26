/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * https://leetcode.com/problems/split-linked-list-in-parts/
 * https://leetcode.com/problems/split-linked-list-in-parts/solution/
 */
class Solution {
  public ListNode[] splitListToParts(ListNode root, int k) {
    ListNode cur = root;
    int N = 0;
    while (cur != null) {
      N++;
      cur = cur.next;
    }
    int width = N / k, rem = N % k;
    ListNode[] ans = new ListNode[k];
    cur = root;
    for (int i = 0; i < k; i++) {
      ListNode dummy = new ListNode(-1), head = dummy;
      for (int j = 0; j < width + (i < rem ? 1 : 0); j++) {
        head.next = new ListNode(cur.val);
        head = head.next;
        if (cur != null) cur = cur.next; 
      }
      ans[i] = dummy.next;
    }
    return ans;
  }
}