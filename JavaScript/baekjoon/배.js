const readline = require("readline");
const rl = readline.createInterface({
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
  const N = parseInt(input.shift());
  const cranes = [];
  let data = input
    .shift()
    .split(" ")
    .map((v) => parseInt(v));
  for (let i = 0; i < N; i++) {
    cranes.push(data[i]);
  }
  const M = parseInt(input.shift());
  data = input
    .shift()
    .split(" ")
    .map((v) => parseInt(v));
  const boxes = [];
  for (let i = 0; i < M; i++) {
    boxes.push(data[i]);
  }
  boxes.sort((a, b) => a - b);
  cranes.sort((a, b) => a - b);
  if (cranes[cranes.length - 1] < boxes[boxes.length - 1]) {
    console.log(-1);
    return;
  }
  let cnt = 0;
  let time = 0;
  const visited = new Array(M).fill(0);
  while (cnt < M) {
    outer: for (let j = N; j >= 0; j--) {
      if (cranes[j] < boxes[0]) continue;
      for (let i = M; i >= 0; i--) {
        if (visited[i]) continue;
        if (cranes[j] >= boxes[i]) {
          visited[i] = 1;
          cnt++;
          continue outer;
        }
      }
    }
    time++;
  }
  console.log(time);
};
