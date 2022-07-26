const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.on("line", (line) => input.push(line)).on("close", () => {
  solve();
  process.exit();
});

const input = [];

const solve = () => {
  let parser = input[0].split(" ");
  const [N, K] = [parseInt(parser[0]), parseInt(parser[1])];
  const item = [];
  const values = [];
  for (let i = 1; i <= N; i++) {
    let parser = input[i].split(" ");
    item[i] = parseInt(parser[0]);
    values[i] = parseInt(parser[1]);
  }
  const dp = Array.from(Array(N + 1), () => Array(K + 1).fill(0));
  for (let i = 1; i <= N; i++) {
    const [weight, value] = [item[i], values[i]];

    for (let k = 0; k <= K; k++) {
      if (k < weight) {
        dp[i][k] = dp[i - 1][k];
      } else {
        dp[i][k] = Math.max(dp[i - 1][k], dp[i - 1][k - weight] + value);
      }
    }
  }
  console.log(dp[N][K]);
};
