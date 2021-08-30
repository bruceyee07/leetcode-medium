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
 * https://leetcode.com/problems/insertion-sort-list/
 * self
 */
class Solution {
  public ListNode insertionSortList(ListNode head) {
    Queue<Integer> q = new PriorityQueue<Integer>();
    while (head != null) {
      q.offer(head.val);
      head = head.next;
    }
    ListNode dummy = new ListNode(-1);
    ListNode node = dummy;
    while (!q.isEmpty()) {
      node.next = new ListNode(q.poll());
      node = node.next;
    }
    return dummy.next;
  }
}