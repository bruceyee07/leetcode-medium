/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @description https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * @type self
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function(head, n) {
  if (head === null) {
    return null;
  }

  const size = getNodeSize(head);
  const frontIndex = size - n;
  let node = new ListNode(-1);

  if (frontIndex < 0 || frontIndex >= size) {
    return head;
  }

  if (frontIndex === 0) {
    return head.next;
  }

  let prevNode = getNodeAtIndex(head, frontIndex - 1);
  let nextNode = getNodeAtIndex(head, frontIndex + 1);

  if (frontIndex === size - 1) {
    prevNode.next = null;
    return head;
  }

  prevNode.next = nextNode;
  return head;
};

function ListNode(val, next) {
  this.val = val === undefined ? 0 : val;
  this.next = next = undefined ? null : next;
}

function getNodeSize(head) {
  let size = 0;
  let node = head;
  while (node !== null) {
    size++;
    node = node.next;
  }
  return size;
}

function getNodeAtIndex(head, index) {
  if (index < 0) {
    return null;
  }

  const size = getNodeSize(head);
  if (index >= size) {
    return null;
  }

  let node = head;
  let cursor = 0;

  while (cursor !== index) {
    node = node.next;
    cursor++;
  }

  return node;
}