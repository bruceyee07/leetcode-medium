/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @description https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * @tutorial https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/discuss/28335/My-accepted-Java-code
 * @param {ListNode} head
 * @return {ListNode}
 */
var deleteDuplicates = function(head) {
  if (head === null || head.next === null) return head;
  if (head.val !== head.next.val) {
    head.next = deleteDuplicates(head.next);
    return head;
  }
  while (head.next && head.val == head.next.val) {
    head = head.next;
  }
  return deleteDuplicates(head.next);
};