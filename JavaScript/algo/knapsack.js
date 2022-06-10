const readline = require("readline");
const input = [];
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.on("line", (line) => input.push(line)).on("close", () => {
  solve();
  process.exit();
});

const solve = () => {
  const arr = [];
  const N = Number(input[0]);
  let parser = input[1].split(" ");
  for (let i = 0; i < N; i++) arr[i] = Number(parser[i]);
  const M = Number(input[2]);
  const dp = new Array(M + 1).fill(Number.MAX_SAFE_INTEGER);
  dp[0] = 0;
  for (let i = 0; i < N; i++) {
    for (let j = arr[i]; j < M + 1; j++) {
      dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
    }
  }
  console.log(dp[M]);
};
