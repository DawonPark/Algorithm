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
  // 1 ~ 1000000000 산성
  // -1 ~ -1000000000 알칼리
  // 두용액을 혼합하여 특성값이 0
  const N = parseInt(input.shift());
  input = input[0].split(" ").map((v) => parseInt(v));
  let answer = Infinity;
  let left = 0;
  let right = N - 1;
  let max = 0,
    min = 0;
  while (left < right) {
    let sum = input[left] + input[right];
    if (sum === 0) {
      console.log(input[left], input[right]);
      return;
    } else if (sum < 0) {
      if (answer > Math.abs(sum)) {
        answer = Math.abs(sum);
        max = input[right];
        min = input[left];
      }
      left++;
    } else {
      if (answer > Math.abs(sum)) {
        answer = Math.abs(sum);
        max = input[right];
        min = input[left];
      }
      right--;
    }
  }
  console.log(min, max);
};
