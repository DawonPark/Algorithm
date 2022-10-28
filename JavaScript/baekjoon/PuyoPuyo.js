const readline = require("readline");
const { ReadableStreamDefaultController } = require("stream/web");

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
  const map = [];
  for (let i = 0; i < 12; i++) {
    map.push(input[i].split(""));
  }

  const gravity = () => {
    for (let i = 0; i < 6; i++) {
      for (let j = 10; j >= 0; j--) {
        if (map[j][i] !== "." && map[j + 1][i] === ".") {
          let pos = -1;
          for (let k = j + 1; k < 12; k++) {
            if (map[k][i] === ".") {
              pos = k;
            }
          }
          map[pos][i] = map[j][i];
          map[j][i] = ".";
        }
      }
    }
  };
  let dx = [0, 0, -1, 1];
  let dy = [-1, 1, 0, 0];
  const bfs = (r, c, color) => {
    const visited = Array.from(Array(12), () => Array(6).fill(0));
    visited[r][c] = 1;
    const queue = [[r, c]];
    const list = [];
    while (queue.length) {
      const [x, y] = queue.shift();
      list.push([x, y]);
      for (let d = 0; d < 4; d++) {
        const nx = x + dx[d];
        const ny = y + dy[d];
        if (nx < 0 || nx >= 12 || ny < 0 || ny >= 12) continue;
        if (visited[nx][ny] || color !== map[nx][ny]) continue;
        visited[nx][ny] = 1;
        queue.push([nx, ny]);
      }
    }
    if (list.length >= 4) {
      for (const [x, y] of list) {
        map[x][y] = ".";
      }
      return 1;
    }
    return 0;
  };
  let ans = 0;

  while (true) {
    let cnt = 0;
    for (let i = 0; i < 12; i++) {
      for (let j = 0; j < 6; j++) {
        if (map[i][j] === ".") continue;
        cnt += bfs(i, j, map[i][j]);
      }
    }
    if (cnt === 0) break;
    ans++;
    gravity();
  }
  console.log(ans);
};
