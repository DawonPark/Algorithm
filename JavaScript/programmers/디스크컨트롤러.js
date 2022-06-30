class Node {
  constructor(val, priority) {
    this.value = val;
    this.priority = priority;
  }
}
class PriorityQueue {
  // 최소 PriorityQueue
  constructor() {
    this.heap = [];
  }

  enqueue(val, priority) {
    this.heap.push(new Node(val, priority));
    this.bubbleUp();
  }

  dequeue() {
    this.swap(0, this.heap.length - 1);
    let val = this.heap.pop();
    this.sinkDown();
    return val;
  }

  sinkDown() {
    let current = this.heap[0];
    let currentIdx = 0;
    let length = this.heap.length;
    let left, right;
    while (true) {
      let swap = null;
      let [leftIdx, rightIdx] = [currentIdx * 2 + 1, currentIdx * 2 + 2];
      if (leftIdx < length) {
        left = this.heap[leftIdx];
        if (left.priority < current.priority) {
          swap = leftIdx;
        }
      }
      if (rightIdx < length) {
        right = this.heap[rightIdx];
        if (
          (swap === null && right.priority < current.priority) ||
          (swap !== null && right.priority < left.priority)
        ) {
          swap = rightIdx;
        }
      }
      if (swap === null) break;
      this.swap(currentIdx, swap);
      currentIdx = swap;
    }
  }

  bubbleUp() {
    let current = this.heap[this.heap.length - 1];
    let currentIdx = this.heap.length - 1;
    let parentIdx = Math.floor((currentIdx - 1) / 2);
    while (currentIdx > 0) {
      if (current.priority >= this.heap[parentIdx].priority) break;
      this.swap(currentIdx, parentIdx);
      currentIdx = parentIdx;
      parentIdx = Math.floor((currentIdx - 1) / 2);
    }
  }

  swap(a, b) {
    [this.heap[a], this.heap[b]] = [this.heap[b], this.heap[a]];
  }
}

function solution(jobs) {
  var answer = 0;
  const queue = new PriorityQueue();

  jobs.sort((a, b) => {
    if (a[0] === b[0]) return a[1] - b[1];
    return a[0] - b[0];
  });
  console.log(jobs);

  queue.enqueue(jobs[0][0], jobs[0][1]);
  let time = jobs[0][0];
  let idx = 1;
  while (queue.heap.length) {
    let { value, priority } = queue.dequeue();
    time += priority;
    answer = answer + time - value;

    outer: while (idx < jobs.length) {
      for (let i = idx; i < jobs.length; i++) {
        if (jobs[i][0] <= time) {
          queue.enqueue(jobs[i][0], jobs[i][1]);
          idx++;
        } else {
          idx = i;
          break outer;
        }
      }
    }

    if (idx < jobs.length && queue.heap.length === 0) {
      queue.enqueue(jobs[idx][0], jobs[idx][1]);
      time = jobs[idx++][0];
    }
  }

  return Math.floor(answer / jobs.length);
}
