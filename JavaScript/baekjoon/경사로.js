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
  const [N, L] = input[0].split(" ").map((v) => parseInt(v));
  let slope = Array.from(Array(N), () => Array(N).fill(0));
  const map = Array(N);
  let answer = 0;
  for (let i = 1; i <= N; i++) {
    map[i - 1] = input[i].split(" ").map((v) => parseInt(v));
  }

  for (let i = 0; i < N; i++) {
    let pre = map[i][0];
    let flag = true;
    for (let j = 1; j < N; j++) {
      if (pre === map[i][j]) continue;
      if (Math.abs(map[i][j] - pre) > 1) {
        flag = false;
        break;
      }
      if (map[i][j] - pre === 1) {
        if (j < L) {
          pre = map[i][j];
          flag = false;
          break;
        }
        for (let k = 0; k < L; k++) {
          if (pre !== map[i][j - k - 1] || slope[i][j - k - 1]) {
            flag = false;
            pre = map[i][j];
            break;
          }
        }
        if (flag) {
          for (let k = 0; k < L; k++) {
            slope[i][j - k - 1] = 1;
          }
          pre = map[i][j];
        }
      } else {
        if (N - j + 1 < L) {
          pre = map[i][j];
          flag = false;
          break;
        }
        for (let k = 0; k < L; k++) {
          if (map[i][j] !== map[i][j + k] || slope[i][j + k]) {
            flag = false;
            pre = map[i][j];
            break;
          }
        }
        if (flag) {
          for (let k = 0; k < L; k++) {
            slope[i][j + k] = 1;
          }
          j += L - 1;
          pre = map[i][j];
        }
      }
    }
    if (flag) {
      answer++;
    }
  }
  slope = Array.from(Array(N), () => Array(N).fill(0));
  for (let i = 0; i < N; i++) {
    let pre = map[0][i];
    let flag = true;
    for (let j = 1; j < N; j++) {
      if (pre === map[j][i]) continue;
      if (Math.abs(map[j][i] - pre) > 1) {
        flag = false;
        break;
      }
      if (map[j][i] - pre === 1) {
        if (j < L) {
          pre = map[j][i];
          flag = false;
          break;
        }
        for (let k = 0; k < L; k++) {
          if (pre !== map[j - k - 1][i] || slope[j - k - 1][i]) {
            flag = false;
            pre = map[j][i];
            break;
          }
        }
        if (flag) {
          for (let k = 0; k < L; k++) {
            slope[j - k - 1][i] = 1;
          }
          pre = map[j][i];
        }
      } else {
        if (N - j < L) {
          pre = map[j][i];
          flag = false;
          break;
        }
        for (let k = 0; k < L; k++) {
          if (map[j][i] !== map[j + k][i] || slope[j + k][i]) {
            flag = false;
            pre = map[j][i];
            break;
          }
        }
        if (flag) {
          for (let k = 0; k < L; k++) {
            slope[j + k][i] = 1;
          }
          j += L - 1;
          pre = map[j][i];
        }
      }
    }
    if (flag) {
      answer++;
    }
  }

  console.log(answer);
};
