const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  solve();
  process.exit();
});

const solve = () => {
  const [N, M, K] = input[0].split(" ").map((v) => parseInt(v));
  const A = [];
  let tree = [];
  for (let i = 1; i <= N; i++) {
    A.push(input[i].split(" ").map((v) => parseInt(v)));
  }
  for (let i = N + 1; i < N + M + 1; i++) {
    tree.push(input[i].split(" ").map((v) => parseInt(v)));
  }
  const map = Array.from(Array(N + 1), () => Array(N + 1).fill(5));

  tree.sort((a, b) => a[2] - b[2]);
  //  0  살아있는나무 1 죽은나무
  for (let n = 0; n < K; n++) {
    const deadTree = [];
    // 봄
    const size = tree.length;
    for (let i = 0; i < size; i++) {
      const [x, y, year] = tree.shift();
      if (map[x][y] >= year) {
        map[x][y] -= year;
        tree.push([x, y, year + 1]);
      } else {
        deadTree.push([x, y, year]);
      }
    }
    // 여름
    for (let i = 0; i < deadTree.length; i++) {
      const [x, y, year] = deadTree[i];
      map[x][y] += Math.floor(year / 2);
    }
    // 가을
    const dx = [0, 0, 1, -1, -1, 1, 1, -1];
    const dy = [1, -1, 0, 0, -1, -1, 1, 1];
    const newTree = [];
    for (let i = 0; i < tree.length; i++) {
      const [x, y, year] = tree[i];
      if (year % 5 === 0) {
        for (let d = 0; d < 8; d++) {
          const nx = x + dx[d];
          const ny = y + dy[d];
          if (nx < 1 || nx >= N + 1 || ny < 1 || ny >= N + 1) continue;
          newTree.push([nx, ny, 1]);
        }
      }
    }
    const newArr = [];
    for (let i = 0; i < newTree.length; i++) {
      newArr.push(newTree[i]);
    }
    for (let i = 0; i < tree.length; i++) {
      newArr.push(tree[i]);
    }
    tree = newArr;
    // 겨울
    for (let i = 0; i < N; i++) {
      for (let j = 0; j < N; j++) {
        map[i + 1][j + 1] += A[i][j];
      }
    }
  }
  console.log(tree.length);
};
