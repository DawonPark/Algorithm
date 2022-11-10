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
  const [H, W] = input[0].split(" ").map((v) => parseInt(v));
  const map = Array.from(Array(H), () => Array(W).fill(0));
  const heights = input[1].split(" ").map((v) => parseInt(v));
  for (let i = 0; i < heights.length; i++) {
    for (let j = 0; j < heights[i]; j++) {
      map[j][i] = 1;
    }
  }
  let ans = 0;
  for (let i = 0; i < H; i++) {
    for (let j = 1; j < W; j++) {
      if (map[i][j - 1] === 1 && map[i][j] === 0) {
        let pos = j;
        while (map[i][pos++] === 0 && pos < W)
          if (map[i][pos - 1] === 1) {
            ans += pos - 1 - j;
            j = pos - 1;
          }
      }
    }
  }

  console.log(ans);
};
