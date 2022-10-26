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
  const map = [
    0,
    2,
    4,
    6,
    8,
    10,
    12,
    14,
    16,
    18,
    20,
    22,
    24,
    26,
    28,
    30,
    32,
    34,
    36,
    38,
    40,
    0, //0 ~ 21
    10,
    13,
    16,
    19,
    25,
    30,
    35,
    40,
    0, //22 ~ 30
    20,
    22,
    24,
    25,
    30,
    35,
    40,
    0, //31 ~ 38
    30,
    28,
    27,
    26,
    25,
    30,
    35,
    40,
    0, //39 ~ 47
  ];
  const arr = [];
  const combination = (cnt, res) => {
    if (cnt === 10) {
      arr.push(res.split("").map((v) => parseInt(v)));
      return;
    }
    for (let i = 0; i < 4; i++) {
      combination(cnt + 1, res + i);
    }
  };
  combination(0, "");
  const dices = input[0].split(" ").map((v) => parseInt(v));
  const go = (current, next, pos, visited) => {
    let cur = pos[current];
    if (cur === 21 || cur === 30 || cur === 38 || cur === 47) return false;
    let nextCur = cur + next;
    if (cur < 21) {
      if (nextCur >= 21) nextCur = 21;
    } else if (cur < 30) {
      if (nextCur >= 30) nextCur = 30;
    } else if (cur < 38) {
      if (nextCur >= 38) nextCur = 38;
    } else if (cur < 47) {
      if (nextCur >= 47) nextCur = 47;
    }
    if (nextCur === 5) nextCur = 22;
    if (nextCur === 10) nextCur = 31;
    if (nextCur === 15) nextCur = 39;
    if (visited[nextCur]) return false;
    if (nextCur !== 21 && nextCur !== 30 && nextCur !== 38 && nextCur !== 47) {
      if (
        nextCur === 20 ||
        nextCur === 29 ||
        nextCur === 37 ||
        nextCur === 46
      ) {
        // 40
        visited[20] = 1;
        visited[29] = 1;
        visited[37] = 1;
        visited[46] = 1;
      } else if (nextCur === 26 || nextCur === 34 || nextCur === 43) {
        // 25
        visited[26] = 1;
        visited[34] = 1;
        visited[43] = 1;
      } else if (nextCur === 27 || nextCur === 35 || nextCur === 44) {
        // 30
        visited[27] = 1;
        visited[35] = 1;
        visited[44] = 1;
      } else if (nextCur === 28 || nextCur === 36 || nextCur === 45) {
        // 35
        visited[28] = 1;
        visited[36] = 1;
        visited[45] = 1;
      } else {
        visited[nextCur] = 1;
      }
    }
    pos[current] = nextCur;
    if (cur == 20 || cur == 29 || cur == 37 || cur == 46) {
      visited[20] = 0;
      visited[29] = 0;
      visited[37] = 0;
      visited[46] = 0;
    } else if (cur == 26 || cur == 34 || cur == 43) {
      visited[26] = 0;
      visited[34] = 0;
      visited[43] = 0;
    } else if (cur == 27 || cur == 35 || cur == 44) {
      visited[27] = 0;
      visited[35] = 0;
      visited[44] = 0;
    } else if (cur == 28 || nextCur == 36 || cur == 45) {
      visited[28] = 0;
      visited[36] = 0;
      visited[45] = 0;
    } else {
      visited[cur] = 0;
    }
    return nextCur;
  };
  let answer = 0;
  for (const order of arr) {
    let sum = 0;
    const visited = Array(map.length).fill(0);
    const pos = Array(4).fill(0);
    for (let i = 0; i < 10; i++) {
      const current = order[i];
      const next = dices[i];
      let check = go(current, next, pos, visited);
      if (check) sum += map[check];
      else break;
    }
    answer = Math.max(answer, sum);
  }
  console.log(answer);
};
