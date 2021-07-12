/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @description https://leetcode.com/problems/reverse-linked-list-ii/
 * @param {ListNode} head
 * @param {number} left
 * @param {number} right
 * @return {ListNode}
 */
var reverseBetween = function(head, left, right) {
  var prev = getNodeAtIndex(head, left - 2);
  var start = getNodeAtIndex(head, left - 1);
  var end = getNodeAtIndex(head, end - 1);
};

/**
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
var reverseList = function(head) {
  var prev = null;
  var cur = head;

  while (cur) {
    let nextNode = cur.next;
    cur.next = prev;
    prev = cur;
    cur = nextNode;
  }

  return prev;
};

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