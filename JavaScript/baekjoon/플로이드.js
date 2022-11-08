const readline = require("readline");

rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});
const input = [];
rl.on("line", (line) => input.push(line)).on("close", () => {
  solve();
  process.exit();
});

const solve = () => {
  const N = parseInt(input[0]);
  const M = parseInt(input[1]);
  const costs = Array.from(Array(N + 1), () => Array(N + 1).fill(Infinity));
  for (let i = 2; i < M + 2; i++) {
    const [s, e, c] = input[i].split(" ").map((v) => parseInt(v));
    costs[s][e] = Math.min(costs[s][e], c);
  }
  for (let k = 1; k < N + 1; k++) {
    for (let i = 1; i < N + 1; i++) {
      for (let j = 1; j < N + 1; j++) {
        if (costs[i][k] + costs[k][j] < costs[i][j])
          costs[i][j] = costs[i][k] + costs[k][j];
      }
    }
  }
  for (let i = 1; i < N + 1; i++) {
    for (let j = 1; j < N + 1; j++) {
      if (i === j) costs[i][j] = 0;
      if (costs[i][j] === Infinity) costs[i][j] = 0;
      process.stdout.write(costs[i][j] + " ");
    }
    console.log();
  }
};
