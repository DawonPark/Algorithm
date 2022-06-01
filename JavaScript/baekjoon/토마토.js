let fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filePath).toString().replace(/\r/g, "").split("\n");

let parser = input[0].split(" ");

let M = Number(parser[0]);
let N = Number(parser[1]);
let dx = [0, 0, -1, 1];
let dy = [1, -1, 0, 0];
const map = Array.from(Array(N), () => Array());
const queue = [];
for (let i = 0; i < N; i++) {
  parser = input[i + 1].split(" ");
  for (let j = 0; j < M; j++) {
    let item = Number(parser[j]);
    if (item === 1) {
      queue.push([i, j]);
    }
    map[i][j] = item;
  }
}
let ans = -1;
let index = 0;
while (queue.length - index > 0) {
  let size = queue.length - index;
  for (let i = 0; i < size; i++) {
    let node = queue[index++];

    for (let d = 0; d < 4; d++) {
      let nx = node[0] + dx[d];
      let ny = node[1] + dy[d];
      if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
      if (map[nx][ny] === 1 || map[nx][ny] === -1) continue;
      map[nx][ny] = 1;
      queue.push([nx, ny]);
    }
  }
  ans++;
}

let flag = false;
for (let i = 0; i < N; i++) {
  if (map[i].includes(0)) {
    console.log(-1);
    flag = true;
    break;
  }
}

if (!flag) console.log(ans);
