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
  const [N, H] = input[0].split(" ").map((v) => parseInt(v));
  const bottom = Array(H + 1).fill(0);
  const top = Array(H + 1).fill(0);
  for (let i = 1; i <= N; i++) {
    const v = parseInt(input[i]);
    if (i % 2 === 1) bottom[v]++;
    else top[H - v + 1]++;
  }

  for (let i = H; i > 0; i--) {
    bottom[i - 1] += bottom[i];
  }
  for (let i = 1; i <= H; i++) {
    top[i] += top[i - 1];
  }
  const len = Array(N).fill(0);
  let min = Infinity;
  for (let i = 1; i <= H; i++) {
    const sum = bottom[i] + top[i];
    min = Math.min(min, sum);
    len[sum]++;
  }
  console.log(min, len[min]);
};
