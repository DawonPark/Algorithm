class Node {
  constructor(value) {
    this.value = value;
    this.next = null;
  }
}

class Queue {
  constructor() {
    this.first = null;
    this.last = null;
    this.size = 0;
  }
  enqueue(val) {
    let newNode = new Node(val);
    if (!this.first) {
      this.first = newNode;
      this.last = newNode;
    } else {
      this.last.next = newNode;
      this.last = newNode;
    }
    return ++this.size;
  }
  dequeue() {
    if (!this.first) return null;
    let temp = this.first;
    if (this.first === this.last) {
      this.last = null;
    }
    this.first = this.first.next;
    this.size--;
    return temp.value;
  }
}

function solution(order) {
  var answer = 0;
  const stack = []; // 보조
  const queue = new Queue(); // 기존
  for (let i = 1; i <= order.length; i++) {
    queue.enqueue(i);
  }
  let idx = 0;

  while (queue.size) {
    while (stack.length && stack[stack.length - 1] === order[idx]) {
      answer++;
      idx++;
      stack.pop();
    }

    if (queue.first.value === order[idx]) {
      queue.dequeue();
      idx++;
      answer++;
    } else {
      stack.push(queue.dequeue());
    }
  }

  while (stack.length && stack[stack.length - 1] === order[idx]) {
    answer++;
    idx++;
    stack.pop();
  }

  return answer;
}
