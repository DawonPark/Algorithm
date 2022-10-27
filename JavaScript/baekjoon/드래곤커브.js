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
  const N = parseInt(input[0]);
  let answer = 0;
  const pattern = Array.from(Array(4), () => Array(1024).fill(0));
  for (let d = 0; d < 4; d++) {
    pattern[d][0] = d;
    for (let i = 1; i <= 10; i++) {
      const start = Math.pow(2, i - 1);
      const end = Math.pow(2, i);
      let idx = start;
      for (let k = start - 1; k >= 0; k--) {
        pattern[d][idx++] = (pattern[d][k] + 1) % 4;
      }
    }
  }

  const map = Array.from(Array(101), () => Array(101).fill(0));
  for (let i = 1; i <= N; i++) {
    let [x, y, d, g] = input[i].split(" ").map((v) => parseInt(v));
    map[x][y] = 1;
    const end = Math.pow(2, g);
    for (let j = 0; j < end; j++) {
      const dir = pattern[d][j];
      switch (dir) {
        case 0:
          x += 1;
          break;
        case 1:
          y -= 1;
          break;
        case 2:
          x -= 1;
          break;
        case 3:
          y += 1;
          break;
      }
      map[x][y] = 1;
    }
  }
  for (let i = 0; i < 100; i++) {
    for (let j = 0; j < 100; j++) {
      if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) {
        answer++;
      }
    }
  }
  console.log(answer);
};
