/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @description https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * @type self
 * @param {ListNode} head
 * @return {ListNode}
 */
var deleteDuplicates = function(head) {
  if (head === null || head.next === null) {
    return head;
  }

  let dummy = new ListNode(-1);
  dummy.next = head;
  
  let node = dummy;
  let map = {};

  while (head) {
    if (map[head.val]) {
      map[head.val]++;
    } else {
      map[head.val] = 1;
    }
    head = head.next;
  }

  while (node.next) {
    if (map[node.next.val] > 1) {
      node.next = node.next.next;
    } else {
      node = node.next;
    }
  }

  return dummy.next;
};

function ListNode(val, next) {
  this.val = (val === undefined ? 0 : val);
  this.next = (next === undefined ? null : next);
}