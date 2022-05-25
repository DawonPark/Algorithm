let fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";

let input = fs.readFileSync(filePath).toString().replace(/\r/g, "").split("\n");
const stack = [];
const N = Number(input[0]);
const num = [];
for (let i = 2; i < 2 + N; i++) {
  num[i - 2] = Number(input[i]);
}

for (let i = 0; i < input[1].trim().length; i++) {
  if ("A" <= input[1].charAt(i) && input[1].charAt(i) <= "Z")
    stack.push(num[input[1].charAt(i).charCodeAt(0) - "A".charCodeAt(0)]);
  else {
    let second = stack.pop();
    let first = stack.pop();
    switch (input[1].charAt(i)) {
      case "+":
        stack.push(first + second);
        break;
      case "-":
        stack.push(first - second);
        break;
      case "*":
        stack.push(first * second);
        break;
      case "/":
        stack.push(first / second);
        break;
    }
  }
}
console.log(stack[0].toFixed(2));
