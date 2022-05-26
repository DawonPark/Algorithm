let fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";

let input = fs.readFileSync(filePath).toString().split("\n");
const stack = [];
let ans = 0;
for (let i = 0; i < input[0].length; i++) {
  const item = input[0].charAt(i);
  if (item === "(") stack.push(item);
  else {
    const before = input[0].charAt(i - 1);
    stack.pop();
    if (before === "(") {
      ans += stack.length;
    } else if (before === ")") {
      ans++;
    }
  }
}
console.log(ans);
