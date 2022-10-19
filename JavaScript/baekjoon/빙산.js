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
  const [N, M] = input[0].split(" ").map((v) => parseInt(v));
  const map = [];
  for (let i = 0; i < N; i++) {
    const arr = input[i + 1].split(" ").map((v) => parseInt(v));
    map.push(arr);
  }
  let answer = 0;
  const dx = [0, 0, -1, 1];
  const dy = [1, -1, 0, 0];
  const island = (x, y, arr) => {
    arr[x][y] = 0;
    for (let d = 0; d < 4; d++) {
      const nx = x + dx[d];
      const ny = y + dy[d];
      if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
      if (arr[nx][ny]) {
        island(nx, ny, arr);
      }
    }
  };

  const check = () => {
    const temp = Array.from(Array(N), () => new Array(M).fill(0));
    for (let i = 0; i < N; i++) {
      for (let j = 0; j < M; j++) {
        temp[i][j] = map[i][j];
      }
    }
    let cnt = 0;
    for (let i = 0; i < N; i++) {
      for (let j = 0; j < M; j++) {
        if (temp[i][j]) {
          cnt++;
          if (cnt >= 2) return true;
          island(i, j, temp);
        }
      }
    }
    if (cnt === 0) return -1;
    return false;
  };

  const dfs = (time) => {
    let res = check();
    if (res === -1) {
      console.log(0);
      return;
    }
    if (res) {
      console.log(time);
      return;
    }
    const list = [];
    for (let i = 0; i < N; i++) {
      for (let j = 0; j < M; j++) {
        if (!map[i][j]) continue;
        let cnt = 0;
        for (let d = 0; d < 4; d++) {
          const nx = i + dx[d];
          const ny = j + dy[d];
          if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
          if (!map[nx][ny]) {
            cnt++;
          }
        }
        if (cnt > 0) list.push([i, j, cnt]);
      }
    }

    for (const arr of list) {
      const [x, y, cnt] = arr;
      if (map[x][y] - cnt > 0) {
        map[x][y] -= cnt;
      } else {
        map[x][y] = 0;
      }
    }
    dfs(time + 1);
  };

  dfs(0);
};
