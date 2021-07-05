/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @description https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
 * @tutorial https://leetcode.com/problems/swapping-nodes-in-a-linked-list/discuss/1009800/C%2B%2BJP3-One-Pass
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
var swapNodes = function(head, k) {
  if (head === null || head.next === null) {
    return head;
  }

  var p1 = p2 = null, node = head;
  while (node) {
    p2 = p2 === null ? null : p2.next;
    if (--k === 0) {
      p1 = node;
      p2 = head;
    }
    node = node.next;
  }
  var temp = p1.val;
  p1.val = p2.val;
  p2.val = temp;

  return head;
};