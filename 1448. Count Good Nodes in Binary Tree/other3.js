/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @description https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 * @tutorial https://leetcode.com/problems/count-good-nodes-in-binary-tree/solution/
 * @param {TreeNode} root
 * @return {number}
 */
var goodNodes = function(root) {
  var count = 0;
  var queue = new MyQueue();
  queue.offer(new Pair(root, -Infinity));

  while (!queue.empty()) {
    var curr = queue.poll();

    if (curr.maxSoFar <= curr.node.val) {
      count++;
    }

    if (curr.node.left !== null) {
      queue.offer(new Pair(curr.node.left, Math.max(curr.node.val, curr.maxSoFar)));
    }

    if (curr.node.right !== null) {
      queue.offer(new Pair(curr.node.right, Math.max(curr.node.val, curr.maxSoFar)));
    }
  }

  return count;
}

class Pair {
  constructor(node, maxSoFar) {
    this.node = node;
    this.maxSoFar = maxSoFar;
  }
}

/**
 * Initialize your data structure here.
 */
var MyQueue = function() {
	this.stack1 = [];
	this.stack2 = [];
};

/**
 * Push element x to the back of queue. 
 * @param {number} x
 * @return {void}
 */
MyQueue.prototype.offer = function(x) {
	this.stack1.push(x);
};

/**
 * Removes the element from in front of queue and returns that element.
 * @return {number}
 */
MyQueue.prototype.poll = function() {
	while (this.stack1.length !== 0) {
		this.stack2.push(this.stack1.pop());
	}

	var pop = this.stack2.pop();

	while (this.stack2.length !== 0) {
		this.stack1.push(this.stack2.pop());
	}

	return pop;
};

/**
 * Get the front element.
 * @return {number}
 */
MyQueue.prototype.peek = function() {
	while (this.stack1.length !== 0) {
		this.stack2.push(this.stack1.pop());
	}

	var pop = this.stack2.pop();
	this.stack2.push(pop);
	while (this.stack2.length !== 0) {
		this.stack1.push(this.stack2.pop());
	}

	return pop;
};

/**
 * Returns whether the queue is empty.
 * @return {boolean}
 */
MyQueue.prototype.empty = function() {
	return this.stack1.length === 0 ? true : false;
};