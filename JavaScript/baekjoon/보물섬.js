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
  const [R, C] = input[0].split(" ").map((v) => parseInt(v));
  const map = Array.from(new Array(R), () => new Array(C));
  let ans = 0;
  const dx = [0, 0, -1, 1];
  const dy = [1, -1, 0, 0];
  for (let i = 1; i <= R; i++) {
    for (let j = 0; j < C; j++) {
      map[i - 1][j] = input[i][j];
    }
  }

  const bfs = (i, j) => {
    const visited = Array.from(new Array(R), () => new Array(C).fill(0));
    const queue = [[i, j, 0]];
    visited[i][j] = 1;
    while (queue.length) {
      const [x, y, time] = queue.shift();
      for (let d = 0; d < 4; d++) {
        let nx = x + dx[d];
        let ny = y + dy[d];
        if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
        if (visited[nx][ny] || map[nx][ny] === "W") continue;
        visited[nx][ny] = 1;
        ans = Math.max(ans, time + 1);
        queue.push([nx, ny, time + 1]);
      }
    }
  };

  for (let i = 0; i < R; i++) {
    for (let j = 0; j < C; j++) {
      if (map[i][j] === "L") bfs(i, j);
    }
  }
  console.log(ans);
};
