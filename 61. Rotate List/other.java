/**
 * https://leetcode.com/problems/rotate-list/
 * https://leetcode.com/problems/rotate-list/discuss/22715/Share-my-java-solution-with-explanation
 */
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
class Solution {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null) return head;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode fast = dummy, slow = dummy;
    int l = 0; // length of head
    for (; fast.next != null; l++)
      fast = fast.next;
    for (int j = 0; j < l - k % l; j++)
      slow = slow.next;
    fast.next = dummy.next;
    dummy.next = slow.next;
    slow.next = null;
    return dummy.next;
  }
}