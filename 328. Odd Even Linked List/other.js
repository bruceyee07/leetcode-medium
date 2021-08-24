/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @description https://leetcode.com/problems/odd-even-linked-list/
 * @tutorial https://leetcode.com/problems/odd-even-linked-list/solution/
 * @param {ListNode} head
 * @return {ListNode}
 */
var oddEvenList = function(head) {
  if (!head) return null;
  var 
    odd = head,
    even = head.next,
    evenHead = even
  ;

  while (even && even.next) {
    odd.next = even.next;
    odd = odd.next;
    even.next = odd.next;
    even = even.next;
  }
  
  odd.next = evenHead;

  return head;
};