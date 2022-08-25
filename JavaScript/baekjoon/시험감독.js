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
  const N = parseInt(input[0]);
  let numbers = input[1].split(" ");
  let parser = input[2].split(" ");
  const B = parseInt(parser[0]);
  const C = parseInt(parser[1]);
  let answer = 0;
  for (let i = 0; i < N; i++) {
    const A = parseInt(numbers[i]);
    if (A <= B) answer++;
    else {
      const number = A - B;
      const bNum = Math.floor(number / C);
      answer = answer + bNum + (number % C ? 2 : 1);
    }
  }
  console.log(answer);
};
