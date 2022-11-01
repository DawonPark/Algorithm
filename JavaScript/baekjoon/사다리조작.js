const { checkPrime } = require("crypto");
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
  const [N, M, H] = input[0].split(" ").map((v) => parseInt(v));
  const map = Array.from(Array(H + 1), () => Array(N + 1).fill(0));
  for (let i = 1; i <= M; i++) {
    const [s, e] = input[i].split(" ").map((v) => parseInt(v));
    map[s][e] = 1;
    map[s][e + 1] = 2;
  }
  let isFinished = false;
  let ans = -1;
  const check = () => {
    for (let i = 1; i <= N; i++) {
      let h = 1;
      let pos = i;
      while (h <= H) {
        if (map[h][pos] === 1) pos++;
        else if (map[h][pos] === 2) pos--;
        h++;
      }
      if (i !== pos) {
        return false;
      }
    }
    return true;
  };
  const dfs = (cnt, n) => {
    if (isFinished) return;
    if (cnt === n) {
      if (check()) {
        isFinished = true;
        ans = n;
      }
      return;
    }
    for (let i = 1; i <= H; i++) {
      for (let j = 1; j < N; j++) {
        if (map[i][j] === 0 && map[i][j + 1] === 0) {
          map[i][j] = 1;
          map[i][j + 1] = 2;
          dfs(cnt + 1, n);
          map[i][j] = 0;
          map[i][j + 1] = 0;
        }
      }
    }
  };
  if (check()) {
    console.log(0);
    return;
  }
  for (let i = 0; i <= 3; i++) {
    if (isFinished) break;
    dfs(0, i);
  }
  console.log(ans);
};
