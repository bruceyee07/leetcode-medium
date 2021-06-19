/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @description https://leetcode.com/problems/add-two-numbers/
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */

//  2 -> 3 -> 4
//  7 -> 9 -> 9

// 432 + 997 = 1429

// 9 -> 2 -> 4 -> 1

var addTwoNumbers = function(l1, l2) {
  var head = null;
  var tail = null;
  var carry = 0;

  while (l1 || l2) {
    var val1 = l1 ? l1.val : 0;
    var val2 = l2 ? l2.val : 0;
    var sum = carry + val1 + val2;
    var current = sum % 10;

    if (!head) {
      head = tail = new ListNode(current);
    } else {
      tail.next = new ListNode(current);
      tail = tail.next;
    }

    carry = Math.floor(sum / 10);

    if (l1) {
      l1 = l1.next;
    }
    if (l2) {
      l2 = l2.next;
    }
  }

  if (carry > 0) {
    tail.next = new ListNode(carry);
    tail = tail.next;
  }

  return head;
};

class ListNode {
  constructor(val, next) {
    this.val = val || 0;
    this.next = next || null;
  }
}

var node12 = new ListNode(2);
var node11 = new ListNode(1, node12); // 1 -> 2

var node22 = new ListNode(9);
var node21 = new ListNode(9, node22); // 9 -> 9

// sum = 21 + 99 = 120
// return 0 -> 2 -> 1