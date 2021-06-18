/**
 * @description https://leetcode-cn.com/problems/01-matrix/
 * @param {number[][]} mat
 * @return {number[][]}
 */
var updateMatrix = function(mat) {
  // four directions: top, bottom, left, right
  var directions = [[-1, 0], [1, 0], [0, -1], [0, 1]];
  var row = mat.length;
  var column = mat[0].length;
  var distances = new Array(row);
  for (let i = 0; i < row; i++) {
    distances[i] = new Array(column);
    distances[i].fill(0);
  }
  var seen = Array.from(Array(row), () => new Array(column));
  var queue = new SinglyLinkedList();

  for (let i = 0; i < row; ++i) {
    for (let j = 0; j < column; ++j) {
      if (mat[i][j] === 0) {
        queue.offer([i, j]);
        seen[i][j] = true;
      }
    }
  }

  while (!queue.isEmpty()) {
    var cell = queue.poll();
    var i = cell.data[0];
    var j = cell.data[1];
    for (let d = 0; d < 4; ++d) {
      var ni = i + directions[d][0];
      var nj = j + directions[d][1];
      if (ni >= 0 && ni < row && nj >= 0 && nj < column && !seen[ni][nj]) {
        distances[ni][nj] = distances[i][j] + 1;
        queue.offer([ni, nj]);
        seen[ni][nj] = true;
      }
    }
  }

  return distances;
};

/**
 * simple SinglyLinkedList implementation
 * refer to http://progressivecoder.com/linked-list-implementation-in-javascript-part-1/
 */
class Node {
  constructor(data, next = null) {
    this.data = data;
    this.next = next;
  }
}

class SinglyLinkedList {
  constructor() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  offer(data) {
    const newNode = new Node(data);
    if (this.size === 0) {
      this.head = newNode;
      this.tail = newNode;
      this.size++;
    } else {
      this.tail.next = newNode;
      this.tail = newNode;
      this.size++;
    }
    return this;
  }

  poll() {
    if (this.size === 0) {
      return null;
    };

    let currentHead = this.head;
    this.head = this.head.next;
    this.size--;
    return currentHead;
  }

  clear() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  isEmpty() {
    return this.size == 0;
  }
}