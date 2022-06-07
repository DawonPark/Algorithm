const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  solve();
  process.exit();
});

class PriorityQueue {
  constructor(comparator) {
    this.heap = [];
    this.comparator = comparator;
  }

  push(value) {
    this.heap.push(value);
    let idx = this.size() - 1;
    while (idx > 0) {
      let p = Math.floor((idx - 1) / 2);
      if (this.comparator(this.heap[p], this.heap[idx]) <= 0) {
        break;
      }
      this.swap(p, idx);
      idx = p;
    }
  }
  pop() {
    this.swap(0, this.size() - 1);
    let idx = 0;
    let value = this.heap.pop();
    while (idx < this.size()) {
      let [left, right] = [idx * 2 + 1, idx * 2 + 2];
      let s = null;
      if (right >= this.size()) {
        s = left;
      } else if (this.comparator(this.heap[left], this.heap[right]) <= 0) {
        s = left;
      } else s = right;

      if (this.comparator(this.heap[s], this.heap[idx]) < 0) {
        this.swap(idx, s);
        idx = s;
      } else break;
    }

    return value;
  }
  swap(x, y) {
    let tmp = this.heap[x];
    this.heap[x] = this.heap[y];
    this.heap[y] = tmp;
  }

  size() {
    return this.heap.length;
  }
}

function solve() {
  let ans = "";
  let maxQueue = new PriorityQueue((a, b) => {
    return b - a;
  });
  let minQueue = new PriorityQueue((a, b) => a - b);
  for (let i = 1; i < input.length; i++) {
    let num = parseInt(input[i]);
    if (minQueue.size() < maxQueue.size()) {
      minQueue.push(num);
    } else {
      maxQueue.push(num);
    }
    if (minQueue.size() > 0) {
      if (minQueue.heap[0] < maxQueue.heap[0]) {
        let minMin = minQueue.pop();
        let maxMin = maxQueue.pop();
        minQueue.push(maxMin);
        maxQueue.push(minMin);
      }
    }
    ans += maxQueue.heap[0] + "\n";
  }
  console.log(ans.trimEnd());
}
