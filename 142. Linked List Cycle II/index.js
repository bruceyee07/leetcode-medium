/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @description https://leetcode.com/problems/linked-list-cycle-ii/
 * @tutorial https://leetcode.com/problems/linked-list-cycle-ii/discuss/44793/O(n)-solution-by-using-two-pointers-without-change-anything
 * @param {ListNode} head
 * @return {ListNode}
 */
var detectCycle = function(head) {
  if (head === null || head.next === null) {
    return null;
  }
  var fastPtr = slowPtr = head;
  var hasCycle = false;
  
  while (fastPtr && fastPtr.next) {
    fastPtr = fastPtr.next.next;
    slowPtr = slowPtr.next;
    if (fastPtr === slowPtr) {
      hasCycle = true;
      break;
    }
  }
  if (!hasCycle) {
    return null;
  }
  slowPtr = head;
  while (slowPtr !== fastPtr) {
    slowPtr = slowPtr.next;
    fastPtr = fastPtr.next;
  }
  return slowPtr;
};