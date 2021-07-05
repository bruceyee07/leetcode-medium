/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @description https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
 * @tutorial https://leetcode.com/problems/swapping-nodes-in-a-linked-list/discuss/1009918/Java-or-Two-Pointers-or-Beginner-Friendly-Detailed-Explanation-or-O(n)-time-O(1)-space
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
var swapNodes = function(head, k) {
  var fast = slow = head;
  var first = second = head;

  for (let i = 1; i < k; i++) {
    fast = fast.next;
  }

  first = fast;

  while (fast.next !== null) {
    fast = fast.next;
    slow = slow.next;
  }

  second = slow;

  var temp = first.val;
  first.val = second.val;
  second.val = temp;

  return head;
};