const answer = [];
let map = [];
function solution(places) {
  for (let i = 0; i < places.length; i++) {
    map = [];
    for (let j = 0; j < places[i].length; j++) {
      map[j] = places[i][j].split("");
    }
    let flag = true;
    outer: for (let j = 0; j < 5; j++) {
      for (let k = 0; k < 5; k++) {
        if (map[j][k] === "P") {
          if (!bfs(j, k)) {
            flag = false;
            break outer;
          }
        }
      }
    }
    answer[i] = flag ? 1 : 0;
  }
  console.log(answer);
  return answer;
}

function bfs(r, c) {
  let dx = [0, 0, -1, 1];
  let dy = [1, -1, 0, 0];
  const queue = [];
  const visited = Array.from(new Array(5), () => []);
  visited[r][c] = true;
  queue.push([r, c]);
  while (queue.length) {
    let [x, y] = queue.shift();
    for (let d = 0; d < 4; d++) {
      let [nx, ny] = [x + dx[d], y + dy[d]];
      if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
      console.log(nx, ny);
      if (visited[nx][ny]) continue;
      let distance = Math.abs(r - nx) + Math.abs(c - ny);

      if (map[nx][ny] === "P" && distance <= 2) return false;
      else if (map[nx][ny] === "O" && distance < 2) {
        visited[nx][ny] = true;
        queue.push([nx, ny]);
      }
    }
  }
  return true;
}
