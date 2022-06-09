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

function solve() {
  let parser = input[0].split(" ");
  let [V, E] = [Number(parser[0]), Number(parser[1])];
  let list = [];
  let dis = new Array(V + 1).fill(Number.MAX_SAFE_INTEGER);
  let check = new Array(V + 1).fill(false);
  for (let i = 1; i <= V; i++) {
    unf[i] = i;
    list[i] = [];
  }
  for (let i = 0; i < E; i++) {
    parser = input[i + 1].split(" ");
    const [s, e, cost] = [
      Number(parser[0]),
      Number(parser[1]),
      Number(parser[2]),
    ];
    list[s].push({ s: e, cost });
    list[e].push({ s, cost });
  }
  dis[1] = 0;
  for (let i = 1; i < V; i++) {
    let [min, index] = [Number.MAX_SAFE_INTEGER, -1];
    for (let j = 0; j <= V; j++) {
      if (!check[j] && dis[j] < min) {
        index = j;
        min = dis[j];
      }
    }
    check[index] = true;

    for (const edge of list[index]) {
      if (check[edge.s]) continue;
      if (dis[edge.s] > edge.cost) {
        dis[edge.s] = edge.cost;
      }
    }
  }
  let ans = 0;
  for (let i = 1; i <= V; i++) ans += dis[i];
  console.log(ans);
}
