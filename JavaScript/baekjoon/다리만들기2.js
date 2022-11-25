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
  const [N, M] = input[0].split(" ").map((v) => parseInt(v));
  const map = [];
  let answer = 0;
  for (let i = 1; i <= N; i++) {
    map.push(input[i].split(" ").map((v) => parseInt(v)));
  }
  const dx = [0, 0, 1, -1];
  const dy = [1, -1, 0, 0];
  const island = (x, y, n) => {
    map[x][y] = n;
    for (let d = 0; d < 4; d++) {
      const nx = x + dx[d];
      const ny = y + dy[d];
      if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
      if (map[nx][ny] === n || !map[nx][ny]) continue;
      island(nx, ny, n);
    }
  };
  let idx = 2;
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < M; j++) {
      if (map[i][j] === 1) island(i, j, idx++);
    }
  }
  const candidate = [];
  const dfs = (n) => {
    for (let i = 0; i < N; i++) {
      for (let j = 0; j < M; j++) {
        if (map[i][j] === n) {
          for (let d = 0; d < 4; d++) {
            let nx = i + dx[d];
            let ny = j + dy[d];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if (map[nx][ny]) continue;
            let cnt = 1;
            let flag = false;
            while (nx >= 0 && nx < N && ny >= 0 && ny < M) {
              if (map[nx][ny] === n) {
                flag = true;
                break;
              }
              if (map[nx][ny]) {
                break;
              }
              nx += dx[d];
              ny += dy[d];
              cnt++;
            }
            if (flag) continue;
            cnt--;
            if (cnt < 2 || (nx < 0) | (nx >= N) || ny < 0 || ny >= M) continue;
            const next = map[nx][ny];
            nx -= dx[d];
            ny -= dy[d];
            candidate.push([n, next, cnt]);
          }
        }
      }
    }
  };
  for (let i = 2; i < idx; i++) {
    dfs(i);
  }
  const p = [];
  const make = () => {
    for (let i = 0; i < idx; i++) {
      p.push(i);
    }
  };
  make();

  const find = (n) => {
    if (p[n] === n) return n;
    return (p[n] = find(p[n]));
  };

  const union = (a, b) => {
    a = find(a);
    b = find(b);
    if (a < b) return (p[b] = a);
    else return (p[a] = b);
  };

  candidate.sort((a, b) => a[2] - b[2]);
  let cnt = 0;

  for (const [s, e, len] of candidate) {
    if (find(s) === find(e)) continue;
    union(s, e);
    answer += len;
    cnt++;
    if (cnt === idx - 3) break;
  }
  if (cnt === idx - 3) console.log(answer);
  else console.log(-1);
};
