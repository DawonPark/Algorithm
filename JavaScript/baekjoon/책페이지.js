const readline = require("readline");

rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});
const input = [];
rl.on("line", (line) => {
  input.push(line);
}).on("close", () => {
  solve();
  process.exit();
});

const solve = () => {
  let N = parseInt(input[0]);
  const cnt = Array(10).fill(0);
  let mul = 1;
  let s = 1;
  const cal = (num, mul) => {
    while (num > 0) {
      const n = num % 10;
      cnt[n] += mul;
      num = Math.floor(num / 10);
    }
  };
  while (s <= N) {
    while (N % 10 !== 9 && s <= N) {
      cal(N, mul);
      N--;
    }
    while (s % 10 !== 0 && s <= N) {
      cal(s, mul);
      s++;
    }
    if (s > N) break;
    s = Math.floor(s / 10);
    N = Math.floor(N / 10);
    for (let i = 0; i < 10; i++) {
      cnt[i] += (N - s + 1) * mul;
    }
    mul *= 10;
  }
  for (const v of cnt) {
    process.stdout.write(v + " ");
  }
};
