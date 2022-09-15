const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const input = [];

rl.on("line", (line) => {
  input.push(line);
}).on("close", () => {
  solve();
  process.exit();
});

const solve = () => {
  let answer = -1;
  const map = [];
  const [N, M] = input[0].split(" ").map((v) => Number(v));
  for (let i = 0; i < N; i++) {
    map.push(input[i + 1].split(""));
  }
  const queue = [];
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < M; j++) {
      if (map[i][j] === "R" || map[i][j] === "B") {
        queue.push([i, j, map[i][j], 0]);
      }
    }
  }
  const move = (rx, ry, bx, by, d) => {
    let newRx, newRy, newBx, newBy;
    switch (d) {
      case 0:
        if (rx === bx) {
          if (ry < by) {
            for (let i = by - 1; i >= 0; i--) {
              if (map[bx][i] === "O") return false;
              if (map[bx][i] === "#") {
                newBx = bx;
                newBy = i + 1;
                break;
              }
            }
            for (let i = ry - 1; i >= 0; i--) {
              if (map[rx][i] === "O") return 1;
              if (map[rx][i] === "#") {
                newRx = rx;
                newRy = i + 1;
                break;
              }
            }
            if (newBy === newRy) {
              newBy++;
            }
          } else {
            for (let i = by - 1; i >= 0; i--) {
              if (map[bx][i] === "O") return false;
              if (map[bx][i] === "#") {
                newBx = bx;
                newBy = i + 1;
                break;
              }
            }
            for (let i = ry - 1; i >= 0; i--) {
              if (map[rx][i] === "O") return 1;
              if (map[rx][i] === "#") {
                newRx = rx;
                newRy = i + 1;
                break;
              }
            }
            if (newRy === newBy) {
              newRy++;
            }
          }
        } else {
          for (let i = ry - 1; i >= 0; i--) {
            if (map[rx][i] === "O") return 1;
            if (map[rx][i] === "#") {
              newRx = rx;
              newRy = i + 1;
              break;
            }
          }
          for (let i = by - 1; i >= 0; i--) {
            if (map[bx][i] === "O") return false;
            if (map[bx][i] === "#") {
              newBx = bx;
              newBy = i + 1;
              break;
            }
          }
        }
        break;
      case 1:
        if (rx === bx) {
          if (ry < by) {
            for (let i = by + 1; i < M; i++) {
              if (map[bx][i] === "O") return false;
              if (map[bx][i] === "#") {
                newBx = bx;
                newBy = i - 1;
                break;
              }
            }
            for (let i = ry + 1; i < M; i++) {
              if (map[rx][i] === "O") return 1;
              if (map[rx][i] === "#") {
                newRx = rx;
                newRy = i - 1;
                break;
              }
            }
            if (newRy === newBy) {
              newRy--;
            }
          } else {
            for (let i = by + 1; i < M; i++) {
              if (map[bx][i] === "O") return false;
              if (map[bx][i] === "#") {
                newBx = bx;
                newBy = i - 1;
                break;
              }
            }
            for (let i = ry + 1; i < M; i++) {
              if (map[rx][i] === "O") return 1;
              if (map[rx][i] === "#") {
                newRx = rx;
                newRy = i - 1;
                break;
              }
            }
            if (newRy === newBy) {
              newBy--;
            }
          }
        } else {
          for (let i = ry + 1; i < M; i++) {
            if (map[rx][i] === "O") return 1;
            if (map[rx][i] === "#") {
              newRx = rx;
              newRy = i - 1;
              break;
            }
          }
          for (let i = by + 1; i < M; i++) {
            if (map[bx][i] === "O") return false;
            if (map[bx][i] === "#") {
              newBx = bx;
              newBy = i - 1;
              break;
            }
          }
        }
        break;
      case 2:
        if (ry === by) {
          if (rx < bx) {
            for (let i = bx - 1; i >= 0; i--) {
              if (map[i][by] === "O") return false;
              if (map[i][by] === "#") {
                newBx = i + 1;
                newBy = by;
                break;
              }
            }
            for (let i = rx - 1; i >= 0; i--) {
              if (map[i][ry] === "O") return 1;
              if (map[i][ry] === "#") {
                newRx = i + 1;
                newRy = ry;
                break;
              }
            }
            if (newRx === newBx) newBx++;
          } else {
            for (let i = bx - 1; i >= 0; i--) {
              if (map[i][by] === "O") return false;
              if (map[i][by] === "#") {
                newBx = i + 1;
                newBy = by;
                break;
              }
            }
            for (let i = rx - 1; i >= 0; i--) {
              if (map[i][ry] === "O") return 1;
              if (map[i][ry] === "#") {
                newRx = i + 1;
                newRy = ry;
                break;
              }
            }
            if (newRx === newBx) newRx++;
          }
        } else {
          for (let i = rx - 1; i >= 0; i--) {
            if (map[i][ry] === "O") return 1;
            if (map[i][ry] === "#") {
              newRx = i + 1;
              newRy = ry;
              break;
            }
          }
          for (let i = bx - 1; i >= 0; i--) {
            if (map[i][by] === "O") return false;
            if (map[i][by] === "#") {
              newBx = i + 1;
              newBy = by;
              break;
            }
          }
        }
        break;
      case 3:
        if (ry === by) {
          if (rx < bx) {
            for (let i = bx + 1; i < N; i++) {
              if (map[i][by] === "O") return false;
              if (map[i][by] === "#") {
                newBx = i - 1;
                newBy = by;
                break;
              }
            }
            for (let i = rx + 1; i < N; i++) {
              if (map[i][ry] === "O") return 1;
              if (map[i][ry] === "#") {
                newRx = i - 1;
                newRy = ry;
                break;
              }
            }
            if (newRx === newBx) newRx--;
          } else {
            for (let i = bx + 1; i < N; i++) {
              if (map[i][by] === "O") return false;
              if (map[i][by] === "#") {
                newBx = i - 1;
                newBy = by;
                break;
              }
            }
            for (let i = rx + 1; i < N; i++) {
              if (map[i][ry] === "O") return 1;
              if (map[i][ry] === "#") {
                newRx = i - 1;
                newRy = ry;
                break;
              }
            }
            if (newRx === newBx) newBx--;
          }
        } else {
          for (let i = rx + 1; i < N; i++) {
            if (map[i][ry] === "O") return 1;
            if (map[i][ry] === "#") {
              newRx = i - 1;
              newRy = ry;
              break;
            }
          }
          for (let i = bx + 1; i < N; i++) {
            if (map[i][by] === "O") return false;
            if (map[i][by] === "#") {
              newBx = i - 1;
              newBy = by;
              break;
            }
          }
        }
        break;
    }
    return [newRx, newRy, newBx, newBy];
  };
  while (queue.length) {
    const [x1, y1, color1] = queue.shift();
    const [x2, y2, color2, cnt] = queue.shift();
    if (cnt === 10) {
      console.log(-1);
      return;
    }
    let bx, by, rx, ry;
    if (color1 === "R") {
      rx = x1;
      ry = y1;
    } else {
      bx = x1;
      by = y1;
    }
    if (color2 === "R") {
      rx = x2;
      ry = y2;
    } else {
      bx = x2;
      by = y2;
    }
    for (let d = 0; d < 4; d++) {
      let result = move(rx, ry, bx, by, d);
      if (result === 1) {
        console.log(cnt + 1);
        return;
      }
      if (
        rx === result[0] &&
        ry === result[1] &&
        bx === result[2] &&
        by === result[3]
      )
        continue;
      if (result) {
        queue.push([result[0], result[1], "R", cnt + 1]);
        queue.push([result[2], result[3], "B", cnt + 1]);
      }
    }
  }
  console.log(-1);
  return;
};
