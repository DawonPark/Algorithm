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
  const [N, C] = input.shift().split(" ");
  input = input.map((v) => parseInt(v));
  input.sort((a, b) => a - b);
  const len = input[input.length - 1];
  let l = 1;
  let r = 1000000000;
  let answer = 1;
  while (l <= r) {
    let mid = Math.floor((l + r) / 2);
    let cnt = 1;
    let start = input[0];
    for (let i = 1; i < input.length; i++) {
      if (input[i] - start >= mid) {
        cnt++;
        start = input[i];
      }
    }
    if (cnt >= C) {
      answer = mid;
      l = mid + 1;
    } else {
      r = mid - 1;
    }
  }
  console.log(answer);
};
