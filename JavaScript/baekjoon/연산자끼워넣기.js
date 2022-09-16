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
  const N = Number(input[0]);
  const num = input[1].split(" ").map((v) => Number(v));
  const op = input[2].split(" ").map((v) => Number(v));
  let max = Number.MIN_SAFE_INTEGER;
  let min = Number.MAX_SAFE_INTEGER;
  const convertOp = (num1, num2, op) => {
    switch (op) {
      case 0:
        return num1 + num2;
      case 1:
        return num1 - num2;
      case 2:
        return num1 * num2;
      case 3:
        let number = num1 / num2;
        return number < 0
          ? Math.ceil(number) === -0
            ? 0
            : Math.ceil(number)
          : Math.floor(number);
    }
  };

  const dfs = (n, sum) => {
    if (n === N - 1) {
      max = Math.max(sum, max);
      min = Math.min(sum, min);
      return;
    }
    for (let i = 0; i < 4; i++) {
      if (op[i]) {
        op[i]--;
        dfs(n + 1, convertOp(sum, num[n + 1], i));
        op[i]++;
      }
    }
  };
  dfs(0, num[0]);
  console.log(max);
  console.log(min);
  console.log(Math.ceil(-0.2));
};
