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
 * https://leetcode.com/problems/add-two-numbers/
 * self
 */
class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();

    while (l1 != null) {
      q1.offer(l1.val);
      l1 = l1.next;
    }

    while (l2 != null) {
      q2.offer(l2.val);
      l2 = l2.next;
    }

    ListNode list = new ListNode(0);
    int sum = 0;
    while (!q1.isEmpty() || !q2.isEmpty()) {
      if (!q1.isEmpty()) sum += q1.poll();
      if (!q2.isEmpty()) sum += q2.poll();
      list.val = sum % 10;
      ListNode head = new ListNode(sum / 10);
      head.next = list;
      list = head;
      sum /= 10;
    }

    ListNode node = list.val == 0 ? list.next : list;
    return reverseList(node);
  }

  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode nextNode = head.next;
    ListNode newHead = reverseList(nextNode);
    nextNode.next = head;
    head.next = null;
    return newHead;
  }
}