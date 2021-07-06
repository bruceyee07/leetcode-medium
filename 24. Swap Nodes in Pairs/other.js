/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @description https://leetcode.com/problems/swap-nodes-in-pairs/
 * @tutorial https://leetcode.com/problems/swap-nodes-in-pairs/discuss/171788/Python-or-Dummynode
 * @param {ListNode} head
 * @return {ListNode}
 */
var swapPairs = function(head) {
  var dummy = new ListNode(-1);
  dummy.next = head;
  var node = dummy;

  while (node.next && node.next.next) {
    var first = node.next;
    var second = node.next.next;
    node.next = second;
    first.next = second.next;
    second.next = first;
    node = node.next.next;
  }

  return dummy.next;
};