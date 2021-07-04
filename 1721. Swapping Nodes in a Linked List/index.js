/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @description https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
 * @type self
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
var swapNodes = function(head, k) {
  if (head === null || head.next === null) {
    return head;
  }
  var arr = linkedListToArray(head);
  var length = arr.length;
  var temp = arr[k - 1];
  arr[k - 1] = arr[length - k];
  arr[length - k] = temp;
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