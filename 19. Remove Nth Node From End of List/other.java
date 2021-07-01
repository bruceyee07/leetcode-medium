/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/discuss/8804/Simple-Java-solution-in-one-pass
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
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode start = new ListNode(0);
    ListNode slow = start, fast = start;
    slow.next = head;
    
    // Move fast in front so that the gap between slow and fast becomes n
    for(int i = 1; i <= n + 1; i++)   {
      fast = fast.next;
    }
    // Move fast to the end, maintaining the gap
    while(fast != null) {
      slow = slow.next;
      fast = fast.next;
    }
    // Skip the desired node
    slow.next = slow.next.next;
    return start.next;
  }
}

/**
 * A one pass solution can be done using pointers. Move one pointer fast --> n+1 places forward, to maintain a gap of n between 
 * the two pointers and then move both at the same speed. Finally, when the fast pointer reaches the end, the slow pointer will 
 * be n+1 places behind - just the right spot for it to be able to skip the next node. Since the question gives that n is valid, 
 * not too many checks have to be put in place. Otherwise, this would be necessary.
 */

/**
 * size = 6
 * n = 2
 * gap = n + 1 = 3
 *                         node to be deleted
 *                               |
 *                               |
 *                               |
 *                               |
 * 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
 *                f
 *      s              f
 *           s              f
 *                s              f
 *                     s              f
 *                     
 *                     s ------> s.next
 */
