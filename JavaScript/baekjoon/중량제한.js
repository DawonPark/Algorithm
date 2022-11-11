const { BADFLAGS } = require("dns");
const readline = require("readline");

rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", (line) => {
  input.push(line);
}).on("close", () => {
  solve();
  process.exit;
});

const bfs = (start, end, weight, graph, N) => {
  const visited = new Array(N + 1).fill(false);
  const queue = [start];
  visited[start] = true;
  while (queue.length) {
    const node = queue.shift();
    if (node === end) return true;
    for (const g of graph[node]) {
      const [next, cost] = g;
      if (!visited[next] && cost >= weight) {
        visited[next] = true;
        queue.push(next);
      }
    }
  }
  return false;
};

const solve = () => {
  const [N, M] = input[0].split(" ").map((v) => parseInt(v));
  const graph = Array.from(Array(N + 1), () => new Array());
  let answer = 0;
  let l = 0;
  let r = 0;
  for (let i = 1; i <= M; i++) {
    const [start, end, weight] = input[i].split(" ").map((v) => parseInt(v));
    graph[start].push([end, weight]);
    graph[end].push([start, weight]);
    r = Math.max(r, weight);
  }
  const [start, end] = input[M + 1].split(" ").map((v) => parseInt(v));
  while (l <= r) {
    const mid = Math.floor((l + r) / 2);
    if (bfs(start, end, mid, graph, N)) {
      answer = mid;
      l = mid + 1;
    } else {
      r = mid - 1;
    }
  }
  console.log(answer);
};
