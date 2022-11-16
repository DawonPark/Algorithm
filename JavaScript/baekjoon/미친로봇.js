const readline = require("readline");

rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});
const input = [];
rl.on("line", (line) => input.push(line)).on("close", () => {
  solve();
  process.exit();
});

const solve = () => {
  const [N, p1, p2, p3, p4] = input[0].split(" ").map((v) => parseInt(v));
  const arr = [p1, p2, p3, p4];
  const dx = [0, 0, -1, 1];
  const dy = [1, -1, 0, 0];
  let answer = 0;
  const visited = Array.from(Array(30), () => Array(30).fill(0));
  const dfs = (x, y, n, percentage) => {
    if (n === N) {
      answer += percentage;
      return;
    }
    for (let i = 0; i < 4; i++) {
      if (!arr[i]) continue;
      const nx = x + dx[i];
      const ny = y + dy[i];
      if (visited[nx][ny]) continue;
      visited[nx][ny] = 1;
      dfs(nx, ny, n + 1, percentage * (arr[i] / 100));
      visited[nx][ny] = 0;
    }
  };
  visited[15][15] = 1;
  dfs(15, 15, 0, 1);
  console.log(answer);
};
