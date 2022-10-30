const { time } = require("console");
const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  solve();
  process.exit();
});

const solve = () => {
  const [N, M] = input[0].split(" ").map((v) => parseInt(v));
  const map = [];
  for (let i = 1; i <= N; i++) {
    map.push(input[i].split(" ").map((v) => parseInt(v)));
  }
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < M; j++) {
      if (map[i][j] === 1) map[i][j] = "c";
    }
  }

  const dx = [0, 0, -1, 1];
  const dy = [1, -1, 0, 0];
  const dfs = (time) => {
    let cnt = 0;
    for (let i = 0; i < N; i++) {
      for (let j = 0; j < M; j++) {
        if (map[i][j] === "c") cnt++;
      }
    }
    if (cnt === 0) {
      console.log(time);
      return;
    }

    const visited = Array.from(Array(N), () => Array(M).fill(0));
    const queue = [[0, 0]];
    map[0][0] = 1;
    visited[0][0] = 1;
    while (queue.length) {
      const [x, y] = queue.shift();
      for (let d = 0; d < 4; d++) {
        const nx = x + dx[d];
        const ny = y + dy[d];
        if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
        if (visited[nx][ny] || map[nx][ny] === "c") continue;
        visited[nx][ny] = 1;
        map[nx][ny] = 1;
        queue.push([nx, ny]);
      }
    }
    const list = [];
    for (let i = 0; i < N; i++) {
      for (let j = 0; j < M; j++) {
        if (map[i][j] !== "c") continue;
        let cnt = 0;
        for (let d = 0; d < 4; d++) {
          const nx = i + dx[d];
          const ny = j + dy[d];
          if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
          if (map[nx][ny] === 1) cnt++;
          if (cnt === 2) break;
        }
        if (cnt >= 2) list.push([i, j]);
      }
    }
    for (const [x, y] of list) {
      map[x][y] = 1;
    }
    dfs(time + 1);
  };

  dfs(0);
};
