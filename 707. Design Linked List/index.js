/**
 * @description https://leetcode.com/problems/design-linked-list/
 * Initialize your data structure here.
 */
var MyLinkedList = function() {
  this.head = null;
  this.tail = null;
  this.size = 0;
};

/**
 * Get the value of the index-th node in the linked list. If the index is invalid, return -1. 
 * @param {number} index
 * @return {number}
 */
MyLinkedList.prototype.get = function(index) {
  if (index < 0 || index >= this.size) {
    return -1;
  }
  return this.getNode(index).val;
};

MyLinkedList.prototype.getNode = function(index) {
  if (index < 0 || index >= this.size) {
    return null;
  }
  if (index === 0) {
    return this.head;
  }
  if (index === this.size - 1) {
    return this.tail;
  }

  let cursor = 0;
  let node = this.head;

  while (cursor !== index) {
    cursor++;
    node = node.next;
  }

  return node;
};

/**
 * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. 
 * @param {number} val
 * @return {void}
 */
MyLinkedList.prototype.addAtHead = function(val) {
  const node = new Node(val);
  node.next = this.head;
  this.head = node;
  
  if (this.size === 0) {
    this.tail = node;
  }

  this.size++;
};

/**
 * Append a node of value val to the last element of the linked list. 
 * @param {number} val
 * @return {void}
 */
MyLinkedList.prototype.addAtTail = function(val) {
  const node = new Node(val);

  if (this.size === 0) {
    this.head = node;
    this.tail = node;
  } else {
    this.tail.next = node;
    this.tail = node;
  }

  this.size++;
};

/**
 * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. 
 * @param {number} index 
 * @param {number} val
 * @return {void}
 */
MyLinkedList.prototype.addAtIndex = function(index, val) {
  if (index <= 0) {
    this.addAtHead(val);
  } else if (index === this.size) {
    this.addAtTail(val);
  } else if (index > 0 && index < this.size) {
    const currentNode = this.getNode(index);
    const prevNode = this.getNode(index - 1);
    const newNode = new Node(val);
    newNode.next = currentNode;
    prevNode.next = newNode;
    this.size++;
  }
};

/**
 * Delete the index-th node in the linked list, if the index is valid. 
 * @param {number} index
 * @return {void}
 */
MyLinkedList.prototype.deleteAtIndex = function(index) {
  if (this.size > 0 && index >= 0 && index < this.size) {
    var node = this.getNode(index);
    var nextNode = node.next;
    var prevNode = this.getNode(index - 1);
    if (index === 0) {
      this.head = nextNode;
    } else if (index === this.size - 1) {
      this.tail = prevNode;
      this.tail.next = null;
    } else {
      prevNode.next = nextNode;
    }
    this.size--;
  }
};

function Node(val = 0, next = null) {
  this.val = val;
  this.next = next;
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * var obj = new MyLinkedList()
 * var param_1 = obj.get(index)
 * obj.addAtHead(val)
 * obj.addAtTail(val)
 * obj.addAtIndex(index,val)
 * obj.deleteAtIndex(index)
 */