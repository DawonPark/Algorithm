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

const solve = () => {
  const N = parseInt(input[0]);
  const tree = Array.from(new Array(N + 1), () => []);
  for (let i = 1; i < N; i++) {
    const [num, child, weight] = input[i].split(" ").map((v) => parseInt(v));
    tree[num].push([child, weight]);
    tree[child].push([num, weight]);
  }
  let max = 0;
  let maxSum = 0;
  let check = new Array(N + 1).fill(0);
  const dfs = (node, sum) => {
    check[node] = 1;
    if (sum > maxSum) {
      maxSum = sum;
      max = node;
    }
    for (const [next, weight] of tree[node]) {
      if (!check[next]) dfs(next, weight + sum);
    }
  };
  dfs(1, 0);
  check = new Array(N + 1).fill(0);
  dfs(max, 0);
  console.log(maxSum);
};
