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
  const map = Array.from(Array(4), () => Array(4));
  let ans = 0;
  for (let i = 0; i < 4; i++) {
    const arr = input[i].split(" ").map((v) => parseInt(v));
    for (let j = 0; j < 4; j++) {
      map[i][j] = [arr[j * 2], arr[j * 2 + 1]];
    }
  }

  const copy = (arr) => {
    const temp = Array.from(Array(4), () => Array(4));
    for (let i = 0; i < 4; i++) {
      for (let j = 0; j < 4; j++) {
        if (arr[i][j].length) {
          temp[i][j] = [...arr[i][j]];
        } else temp[i][j] = arr[i][j];
      }
    }
    return temp;
  };

  const dx = [, -1, -1, 0, 1, 1, 1, 0, -1];
  const dy = [, 0, -1, -1, -1, 0, 1, 1, 1];
  const move = (arr) => {
    const list = Array(16);
    for (let i = 0; i <= 16; i++) {
      list[i] = [-1, 0, i, 0];
    }
    for (let i = 0; i < 4; i++) {
      for (let j = 0; j < 4; j++) {
        if (arr[i][j] === 1 || arr[i][j] === 0) continue;
        const [num, dir] = arr[i][j];
        list[num][0] = i;
        list[num][1] = j;
        list[num][3] = dir;
      }
    }
    list.sort((a, b) => a[2] - b[2]);
    for (const [x, y, num, dir] of list) {
      if (x === -1) continue;
      for (let d = 0; d < 8; d++) {
        const cDir = dir + d >= 9 ? ((dir + d) % 9) + 1 : dir + d;
        const nx = x + dx[cDir];
        const ny = y + dy[cDir];
        if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) continue;
        if (arr[nx][ny] === 1) continue;
        if (arr[nx][ny] === 0) {
          arr[nx][ny] = [num, cDir];
          arr[x][y] = 0;
          break;
        }
        list[arr[nx][ny][0]][0] = x;
        list[arr[nx][ny][0]][1] = y;
        arr[x][y] = [...arr[nx][ny]];
        arr[nx][ny] = [num, cDir];
        break;
      }
    }
  };
  const dfs = (x, y, sum, sea, cnt) => {
    sum += sea[x][y][0];
    let dir = sea[x][y][1];
    sea[x][y] = 1;
    ans = Math.max(sum, ans);
    move(sea);
    for (let n = 1; n < 4; n++) {
      const nx = x + dx[dir] * n;
      const ny = y + dy[dir] * n;
      if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) break;
      if (sea[nx][ny] === 0) continue;

      const temp = copy(sea);
      temp[x][y] = 0;
      dfs(nx, ny, sum, temp, cnt + 1);
    }
  };

  dfs(0, 0, 0, map, 0);
  console.log(ans);
};
