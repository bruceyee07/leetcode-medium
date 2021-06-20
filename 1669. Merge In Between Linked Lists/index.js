/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @description https://leetcode.com/problems/merge-in-between-linked-lists/
 * @type self (it means I solved this problem independently)
 * @param {ListNode} list1
 * @param {number} a
 * @param {number} b
 * @param {ListNode} list2
 * @return {ListNode}
 */
var mergeInBetween = function(list1, a, b, list2) {
  var prevNode = getNodeAtIndex(list1, a - 1);
  var nextNode = getNodeAtIndex(list1, b + 1);
  var headNodeOfList2 = getNodeAtIndex(list2, 0);
  var sizeOfList2 = getNodeSize(list2);
  var tailNodeOfList2 = getNodeAtIndex(list2, sizeOfList2 - 1);
  prevNode.next = headNodeOfList2;
  tailNodeOfList2.next = nextNode;
  return list1;
};

function ListNode(val, next) {
  this.val = (val === undefined ? 0 : val);
  this.next = (next === undefined ? null : next);
}

function getNodeAtIndex(head, index) {
  let node = head;
  let cursor = 0;

  while (cursor !== index) {
    node = node.next;
    cursor++;
  }

  return node;
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