/**
 * @description https://leetcode.com/problems/sort-list/
 * @tutorial https://leetcode.com/problems/sort-list/solution/
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

  var mid = getMid(head);
  var left = sortList(head);
  var right = sortList(mid);
  
  return merge(left, right);
};

function merge(l1, l2) {
  var dummy = new ListNode(-1);
  var node = dummy;

  while (l1 && l2) {
    if (l1.val < l2.val) {
      node.next = l1;
      l1 = l1.next
      node = node.next;
    } else {
      node.next = l2;
      l2 = l2.next;
      node = node.next
    }
  }

  node.next = l1 !== null ? l1 : l2;

  return dummy.next;
}

// I am confused with this function
function getMid(head) {
  var midPrev = null;
  while (head && head.next) {
    midPrev = midPrev === null ? head : midPrev.next;
    head = head.next.next;
  }
  var mid = midPrev.next;
  midPrev.next = null;
  return mid;
}