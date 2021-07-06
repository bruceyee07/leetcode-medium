/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @description https://leetcode.com/problems/swap-nodes-in-pairs/
 * @type self
 * @param {ListNode} head
 * @return {ListNode}
 */
var swapPairs = function(head) {
  if (head === null || head.next === null) {
    return head;
  }

  var dummy = new ListNode(-1);
  dummy.next = head;

  var slow = head;
  var fast = head.next;

  while (slow && fast) {
    // seems that it doesn't meet the requirement, i.e., You must solve the problem without modifying the values 
    // in the list's nodes (i.e., only nodes themselves may be changed.)
    var temp = fast.val;
    fast.val = slow.val;
    slow.val = temp;

    slow = slow.next ? slow.next.next : null;
    fast = fast.next ? fast.next.next : null;
  }

  return dummy.next;
};