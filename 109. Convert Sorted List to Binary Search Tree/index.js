/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @description https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 * @type self
 * @param {ListNode} head
 * @return {TreeNode}
 */
var sortedListToBST = function(head) {
  var arr = [];
  while (head) {
    arr.push(head.val);
    head = head.next;
  }
  console.log(arr);
  return sortedArrayToBST(arr);
};

function sortedArrayToBST(arr) {
  if (!arr.length) {
    return null;
  }
  const midIndex = Math.floor(arr.length / 2);
  var root = new TreeNode(arr[midIndex]);
  root.left = sortedArrayToBST(arr.slice(0, midIndex));
  root.right = sortedArrayToBST(arr.slice(midIndex + 1));

  return root;
}