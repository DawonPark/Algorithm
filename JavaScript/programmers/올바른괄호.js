function solution(s) {
  const stack = [];

  for (const ch of s) {
    if (ch === "(") stack.push(ch);
    else {
      if (stack[stack.length - 1] === "(") stack.pop();
      else return false;
    }
  }
  if (stack.length) return false;

  return true;
}
