/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @description https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * @tutorial https://leetcode.com/problems/remove-nth-node-from-end-of-list/discuss/8804/Simple-Java-solution-in-one-pass
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function(head, n) {
  var dummy = new ListNode(-1);
  dummy.next = head;

  var slow = fast = dummy;

  for (let i = 1; i <= n + 1; i++) {
    fast = fast.next;
  }

  while (fast) {
    fast = fast.next;
    slow = slow.next;
  }

  slow.next = slow.next.next;

  return dummy.next;
};

/**
 * A one pass solution can be done using pointers. Move one pointer fast --> n+1 places forward, to maintain a gap of n between 
 * the two pointers and then move both at the same speed. Finally, when the fast pointer reaches the end, the slow pointer will 
 * be n+1 places behind - just the right spot for it to be able to skip the next node. Since the question gives that n is valid, 
 * not too many checks have to be put in place. Otherwise, this would be necessary.
 */

/**
 * size = 6
 * n = 6
 * gap = n + 1 = 7
 * node to be deleted
 *      |
 *      |
 *      |
 *      |
 * 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
 * s                                  f
 *                     
 * s ------> s.next
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
