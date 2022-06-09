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
      if (
        this.comparator(this.heap[p].priority, this.heap[idx].priority) <= 0
      ) {
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
      if (left >= this.size()) break;
      if (right >= this.size()) {
        s = left;
      } else if (
        this.comparator(this.heap[left].priority, this.heap[right].priority) <=
        0
      ) {
        s = left;
      } else s = right;
      if (this.comparator(this.heap[s].priority, this.heap[idx].priority) < 0) {
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
  let ans = 0;
  const pq = new PriorityQueue((a, b) => a - b);
  let parser = input[0].split(" ");
  const N = Number(parser[0]);
  const M = Number(parser[1]);
  let list = [];
  let dis = new Array(N + 1).fill(Number.MAX_SAFE_INTEGER);
  for (let i = 1; i < N + 1; i++) {
    list[i] = [];
  }
  for (let i = 0; i < M; i++) {
    parser = input[i + 1].split(" ");
    list[Number(parser[0])].push({
      v: Number(parser[1]),
      cost: Number(parser[2]),
    });
  }

  pq.push({ value: 1, priority: 0 });
  dis[1] = 0;
  while (pq.heap.length > 0) {
    const data = pq.pop();
    const [now, nowCost] = [data.value, data.priority];
    if (nowCost > dis[now]) continue;
    for (const obj of list[now]) {
      if (dis[obj.v] > nowCost + obj.cost) {
        dis[obj.v] = nowCost + obj.cost;
        pq.push({ value: obj.v, priority: nowCost + obj.cost });
      }
    }
  }
  console.log(ans);
}
