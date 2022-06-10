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

function find(v) {
  if (unf[v] === v) return v;
  else return (unf[v] = find(unf[v]));
}

function union(a, b) {
  let fa = find(a);
  let fb = find(b);
  if (fa !== fb) unf[fa] = fb;
}

function solve() {
  let parser = input[0].split(" ");
  let [V, E] = [Number(parser[0]), Number(parser[1])];
  let list = [];
  for (let i = 1; i <= V; i++) {
    unf[i] = i;
  }
  for (let i = 0; i < E; i++) {
    parser = input[i + 1].split(" ");
    list.push({
      s: Number(parser[0]),
      e: Number(parser[1]),
      cost: Number(parser[2]),
    });
  }
  list.sort((a, b) => a.cost - b.cost);
  let ans = 0;
  let cnt = 0;
  for (const edge of list) {
    let [a, b] = [find(edge.s), find(edge.e)];
    if (a !== b) {
      ans += edge.cost;
      union(edge.s, edge.e);
      cnt++;
    }
    if (cnt === V - 1) break;
  }
  console.log(ans);
}
