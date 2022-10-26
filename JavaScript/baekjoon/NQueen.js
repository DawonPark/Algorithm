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
  const N = parseInt(input[0]);
  const map = Array(N).fill(0);
  let answer = 0;

  const go = (col, row) => {
    for (let i = 0; i < col; i++) {
      if (row === map[i]) return false;
    }

    for (let i = 0; i < col; i++) {
      if (Math.abs(row - map[i]) === Math.abs(col - i)) return false;
    }

    return true;
  };

  const dfs = (cnt) => {
    if (cnt === N) {
      answer++;
      return;
    }

    for (let i = 0; i < N; i++) {
      if (go(cnt, i)) {
        map[cnt] = i;
        dfs(cnt + 1);
      }
    }
  };
  dfs(0);
  console.log(answer);
};
