let visited, answer, map;
let dx = [1, 0, -1, 0]; // 하 우 상 좌
let dy = [0, 1, 0, -1];
// L -> d=== 3 ? 0 : d+1;
// R -> d=== 0 ? 3 : d-1;
function solution(grid) {
  answer = [];

  map = [];
  visited = Array.from(new Array(grid.length), () =>
    Array.from(new Array(grid[0].length), () => new Array(4).fill(false))
  );
  for (let i = 0; i < grid.length; i++) {
    map[i] = grid[i].split("");
  }
  for (let i = 0; i < map.length; i++) {
    for (let j = 0; j < map[0].length; j++) {
      for (let d = 0; d < 4; d++) {
        if (!visited[i][j][d]) solve(i, j, d);
      }
    }
  }

  answer.sort((a, b) => a - b);
  return answer;
}

function solve(i, j, d) {
  let queue = [];
  queue.push([i, j, d]);
  let cnt = 0;
  while (queue.length) {
    cnt++;
    let [x, y, currentD] = queue.shift();
    visited[x][y][currentD] = true;

    const dir = map[x][y];
    if (dir === "L") {
      currentD = currentD === 3 ? 0 : currentD + 1;
    } else if (dir === "R") {
      currentD = currentD === 0 ? 3 : currentD - 1;
    }

    let [nx, ny] = [x + dx[currentD], y + dy[currentD]];
    if (nx < 0) {
      nx = map.length - 1;
    }
    if (nx >= map.length) {
      nx = 0;
    }
    if (ny < 0) {
      ny = map[0].length - 1;
    }
    if (ny >= map[0].length) {
      ny = 0;
    }

    if (!visited[nx][ny][currentD]) {
      queue.push([nx, ny, currentD]);
    }
  }
  answer.push(cnt);
}
