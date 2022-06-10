const readLine = require("readline");

const rl = readLine.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];
let arr = [];
let dp = [];
rl.on("line", (line) => input.push(line)).on("close", () => {
  solve();
  process.exit();
});

const solve = () => {
  let n = Number(input[0]);
  let parser = input[1].split(" ");
  for (let i = 0; i < n; i++) arr[i] = Number(parser[i]);
  dp[0] = 1;
  let ans = 0;
  console.log(arr);
  for (let i = 1; i < n; i++) {
    let max = 0;
    for (let j = i - 1; j >= 0; j--) {
      if (arr[j] < arr[i] && dp[j] > max) {
        max = dp[j];
      }
      dp[i] = max + 1;
    }
    ans = Math.max(ans, dp[i]);
  }
  console.log(ans);
};
