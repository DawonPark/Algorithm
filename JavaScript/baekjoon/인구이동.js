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

let check = 0;
let ans = 0;
const dx = [0, 0, -1, 1];
const dy = [1, -1, 0, 0];
let N, L, R, map;
const solve = () => {
  let parser = input[0].split(" ");
  [N, L, R] = [Number(parser[0]), Number(parser[1]), Number(parser[2])];
  map = Array.from(new Array(N), () => new Array(N));
  for (let i = 0; i < N; i++) {
    parser = input[i + 1].split(" ");
    for (let j = 0; j < N; j++) {
      map[i][j] = Number(parser[j]);
    }
  }
  while (true) {
    check = 0;
    const visited = Array.from(new Array(N), () => new Array(N).fill(false));
    for (let i = 0; i < N; i++) {
      for (let j = 0; j < N; j++) {
        if (!visited[i][j]) go(i, j, visited);
      }
    }
    if (check === 0) break;
    ans++;
  }
  console.log(ans);
};
const go = (i, j, visited) => {
  const queue = [];
  const list = [];
  queue.push([i, j]);
  list.push([i, j]);
  visited[i][j] = true;
  let sum = map[i][j];
  while (queue.length > 0) {
    let [x, y] = queue.pop();
    for (let d = 0; d < 4; d++) {
      let nx = x + dx[d];
      let ny = y + dy[d];
      if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
      if (visited[nx][ny]) continue;
      if (
        Math.abs(map[x][y] - map[nx][ny]) >= L &&
        Math.abs(map[x][y] - map[nx][ny]) <= R
      ) {
        visited[nx][ny] = true;
        queue.push([nx, ny]);
        list.push([nx, ny]);
        sum += map[nx][ny];
      }
    }
  }

  if (list.length > 1) {
    for (const [x, y] of list) {
      map[x][y] = Math.floor(sum / list.length);
    }
    check++;
  }
};
