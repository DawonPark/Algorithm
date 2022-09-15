const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  solve();
  process.exit();
});

const solve = () => {
  const N = parseInt(input[0]);
  const arr = input[1].split(" ").map((v) => parseInt(v));
  let ans = Infinity;
  let right = N - 1;
  let left = 0;
  let min = 0;
  let max = 0;
  arr.sort((a, b) => a - b);
  while (left < right) {
    let sum = arr[left] + arr[right];
    if (ans > Math.abs(sum)) {
      min = arr[left];
      max = arr[right];
      ans = Math.abs(sum);
    }
    if (sum === 0) break;
    if (sum < 0) left++;
    if (sum > 0) right--;
  }
  console.log(min + " " + max);
};
