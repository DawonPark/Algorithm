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
  const arr = [];
  let answer = 0;
  for (let i = 0; i < 4; i++) {
    arr.push(input[i].split("").map((v) => parseInt(v)));
  }
  const K = parseInt(input[4]);

  // 톱니바퀴 순서, 상태 , 방향
  const rotate = (n, stateT, dir, visited) => {
    visited[n] = 1;
    let state = stateT[n];
    if (n > 0 && stateT[n - 1][2] !== state[6] && !visited[n - 1]) {
      rotate(n - 1, stateT, dir * -1, visited);
    }
    if (n < 3 && state[2] !== stateT[n + 1][6] && !visited[n + 1]) {
      rotate(n + 1, stateT, dir * -1, visited);
    }

    if (dir === 1) {
      // 시계방향
      let temp = state[7];
      for (let i = 7; i > 0; i--) {
        state[i] = state[i - 1];
      }
      state[0] = temp;
    } else {
      let temp = state[0];
      for (let i = 1; i <= 7; i++) {
        state[i - 1] = state[i];
      }
      state[7] = temp;
    }
  };
  for (let i = 0; i < K; i++) {
    const [n, dir] = input[5 + i].split(" ").map((v) => parseInt(v));
    const visited = new Array(4).fill(0);
    rotate(n - 1, arr, dir, visited);
  }
  for (let i = 0; i < 4; i++) {
    if (arr[i][0]) answer += Math.pow(2, i);
  }
  console.log(answer);
};
