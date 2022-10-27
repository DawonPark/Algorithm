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
  for (let i = 1; i <= N; i++) {
    map.push(input[i].split(" ").map((v) => parseInt(v)));
  }
  const virusList = [];
  let cnt = 0;
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      if (map[i][j] === 2) {
        virusList.push([i, j]);
      }
      if (map[i][j] === 0) {
        cnt++;
      }
    }
  }
  if (cnt === 0) {
    console.log(0);
    return;
  }
  const dx = [0, 0, -1, 1];
  const dy = [1, -1, 0, 0];
  let answer = Number.MAX_SAFE_INTEGER;
  const spread = (arr) => {
    if (answer === 0) return;
    const queue = [];
    const visited = Array.from(Array(N), () => Array(N).fill(0));
    for (const v of arr) {
      queue.push([virusList[v][0], virusList[v][1], 1]);
      visited[virusList[v][0]][virusList[v][1]] = 1;
    }
    let time = 0;
    let count = 0;
    while (queue.length) {
      const [x, y, vTime] = queue.shift();
      time = vTime;
      for (let d = 0; d < 4; d++) {
        const nx = x + dx[d];
        const ny = y + dy[d];
        if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
        if (visited[nx][ny]) continue;
        if (map[nx][ny] === 0) {
          visited[nx][ny] = 1;
          count++;
          queue.push([nx, ny, vTime + 1]);
        }
        if (map[nx][ny] === 2) {
          visited[nx][ny] = 1;
          queue.push([nx, ny, vTime + 1]);
        }
      }
      if (count === cnt) {
        time++;
        break;
      }
    }
    if (count === cnt) answer = Math.min(answer, time - 1);
  };

  const combination = (start, cnt, arr) => {
    if (cnt === M) {
      spread(arr);
      return;
    }
    for (let i = start; i < virusList.length; i++) {
      arr[cnt] = i;
      combination(i + 1, cnt + 1, arr);
    }
  };

  combination(0, 0, []);
  console.log(answer === Number.MAX_SAFE_INTEGER ? -1 : answer);
};
