/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @description https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
var swapNodes = function(head, k) {
  var size = getNodeSize(head);
  var swapHeadNode = getNodeAtIndex(head, k);
  var swapHeadPrevNode = getNodeAtIndex(head, k - 1);
  var swapHeadNextNode = swapHeadNode.next;
 
  var swapTailNode = getNodeAtIndex(head, size - k + 1);
  var swapTailPrevNode = getNodeAtIndex(head, size - k);
  var swapTailNextNode = swapTailNode.next;

  if (size === 1) {
    return head;
  } else if (size === 2) {
    swapHeadNode.next = null;
    swapTailNode.next = swapHeadNode;
    return swapTailNode;
  } else if (size === k) {
    return head;
  } else if (size === 2 * k) {
    /**
     * 这种情况是两个交换的节点是相邻节点，如果直接粗暴地用 else 分支的逻辑去解的话，会产生环的情况
     * 例如 Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
     * Output: [7,9,6,6,8,7,3,0,9,5]
     * 会有无限多个8的节点
     */
    swapHeadPrevNode.next = swapTailNode;
    swapTailNode.next = swapHeadNode;
    swapHeadNode.next = swapTailNextNode;
  } else {
    swapHeadPrevNode.next = swapTailNode;
    swapTailNode.next = swapHeadNextNode;
    swapTailPrevNode.next = swapHeadNode;
    swapHeadNode.next = swapTailNextNode;
  }

  return head;
};

function ListNode(val, next) {
  this.val = (val === undefined ? 0 : val);
  this.next = (next === undefined ? null : next);
}

function getNodeAtIndex(head, index) {
  if (index < 1) {
    return null;
  }

  const size = getNodeSize(head);
  if (index > size) {
    return null;
  }

  let node = head;
  let cursor = 1;

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
