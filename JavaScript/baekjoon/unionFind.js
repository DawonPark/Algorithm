const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];
let unf = [];
rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  solve();
  process.exit();
});

function find(x) {
  if (x === unf[x]) return x;
  else return (unf[x] = find(unf[x]));
}

function union(x, y) {
  let a = find(x);
  let b = find(y);
  if (a !== b) unf[a] = b;
}

function solve() {
  let parser = input[0].split(" ");
  let n = Number(parser[0]);
  let m = Number(parser[1]);
  for (let i = 1; i <= n; i++) unf[i] = i;
  for (let i = 1; i <= m; i++) {
    parser = input[i + 1].split(" ");
    union(Number(parser[0]), Number(parser[1]));
  }
  parser = input[m + 1].split(" ");
  let fa = find(Number(parser[0]));
  let fb = find(Number(parser[1]));
  console.log(unf);
  if (fa === fb) console.log("YES");
  else console.log("NO");
}
