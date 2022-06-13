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
  let parser = input[0].split(" ");
  const [r, c, k] = [Number(parser[0]), Number(parser[1]), Number(parser[2])];
  const list = Array.from(Array(100), () => new Array(100).fill(0));
  for (let i = 0; i < 3; i++) {
    parser = input[i + 1].split(" ");
    for (let j = 0; j < 3; j++) {
      list[i][j] = Number(parser[j]);
    }
  }
  let time = 0;
  let [R, C] = [3, 3];
  while (list[r - 1][c - 1] !== k && time <= 100) {
    if (R >= C) {
      let length = 0;
      for (let i = 0; i < R; i++) {
        let count = new Array(101).fill(0);
        for (let j = 0; j < C; j++) {
          count[list[i][j]]++;
        }
        let idx = 0;
        outer: for (let j = 1; j <= C; j++) {
          for (let k = 1; k <= 100; k++) {
            if (count[k] === j) {
              list[i][idx++] = k;
              list[i][idx++] = j;
            }
            if (idx >= 100) break outer;
          }
        }
        for (let j = idx; j <= C && j < 100; j++) list[i][j] = 0;
        length = Math.max(length, idx);
      }
      C = length;
    } else {
      let length = 0;
      for (let i = 0; i < C; i++) {
        let count = new Array(101).fill(0);
        for (let j = 0; j < R; j++) {
          count[list[j][i]]++;
        }
        let idx = 0;
        outer: for (let j = 1; j <= R; j++) {
          for (let k = 1; k <= 100; k++) {
            if (count[k] === j) {
              list[idx++][i] = k;
              list[idx++][i] = j;
            }
            if (idx >= 100) break outer;
          }
        }
        for (let j = idx; j <= R && j < 100; j++) list[j][i] = 0;
        length = Math.max(length, idx);
      }
      R = length;
    }
    time++;
  }
  console.log(time <= 100 ? time : -1);
};
