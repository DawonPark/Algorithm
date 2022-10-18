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
  let dice = [0, 0, 0, 0, 0, 0]; // top down east west north south
  let [N, M, x, y, K] = input[0].split(" ").map((v) => parseInt(v));
  const map = Array.from(Array(M), () => new Array(N));
  const rotate = (d) => {
    const [top, down, east, west, north, south] = dice;
    switch (d) {
      case 1:
        dice = [west, east, top, down, north, south];
        break;
      case 2:
        dice = [east, west, down, top, north, south];
        break;
      case 3:
        dice = [south, north, east, west, top, down];
        break;
      case 4:
        dice = [north, south, east, west, down, top];
        break;
    }
  };
  for (let i = 1; i <= N; i++) {
    let arr = input[i].split(" ").map((v) => parseInt(v));
    for (let j = 0; j < M; j++) {
      map[j][i - 1] = arr[j];
    }
  }
  const command = input[N + 1].split(" ").map((v) => parseInt(v));
  const dx = [, 0, 0, -1, 1];
  const dy = [, 1, -1, 0, 0]; // 동 서 북 남
  for (const c of command) {
    let nx = x + dx[c];
    let ny = y + dy[c];
    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
    rotate(c);
    if (map[ny][nx] === 0) {
      map[ny][nx] = dice[1];
    } else {
      dice[1] = map[ny][nx];
      map[ny][nx] = 0;
    }
    console.log(dice[0]);
    x = nx;
    y = ny;
  }
};
