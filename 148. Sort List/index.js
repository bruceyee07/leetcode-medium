/**
 * @description https://leetcode.com/problems/sort-list/
 * @type self
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var sortList = function(head) {
  if (head === null || head.next === null) {
    return head;
  }

  var arr = linkedListToArray(head);
  arr = arr.sort((a, b) => a - b);

  return arrayToLinkedList(arr);
};

function linkedListToArray(list) {
  var arr = [];
  var node = list;
  while (node) {
    arr.push(node.val);
    node = node.next;
  }
  return arr;
}

function arrayToLinkedList(arr) {
  const length = arr.length;
  if (length === 0) {
    return null;
  }
  var head = new ListNode(arr[length - 1]);
  for (let i = arr.length - 2; i >= 0; i--) {
    head = new ListNode(arr[i], head);
  }
  return head;
}
