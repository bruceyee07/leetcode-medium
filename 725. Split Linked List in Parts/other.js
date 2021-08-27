/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @description https://leetcode.com/problems/split-linked-list-in-parts/
 * @tutorial https://leetcode.com/problems/split-linked-list-in-parts/solution/
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode[]}
 */
var splitListToParts = function(root, k) {
  var cur = root;
  var size = 0;
  while (cur !== null) {
    size++;
    cur = cur.next;
  }
  var ans = new Array(k);
  var width = Math.floor(size / k), rem = size % k;
  cur = root;
  for (let i = 0; i < k; i++) {
    var head = cur;
    for (let j = 0; j < width + (i < rem ? 1 : 0) - 1; j++) {
      if (cur != null) {
        cur = cur.next;
      }
    }
    if (cur != null) {
      var prev = cur;
      cur = cur.next;
      prev.next = null;
    }
    ans[i] = head;
  }
  return ans;
};