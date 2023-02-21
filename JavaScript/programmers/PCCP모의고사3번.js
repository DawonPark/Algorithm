function solution(queries) {
  const answer = [];
  const arr = ["RR", "Rr", "Rr", "rr"];
  let n = queries.length;
  for (let i = 0; i < n; i++) {
    let g = queries[i][0];
    let p = queries[i][1] - 1;
    if (g === 1) {
      answer[i] = "Rr";
      continue;
    }
    const stack = [];
    while (g-- > 1) {
      stack.push(p % 4);
      p = Math.floor(p / 4);
    }
    let flag = false;
    while (stack.length) {
      let s = stack.pop();
      if (s === 0 || s === 3) {
        answer[i] = arr[s];
        flag = true;
        break;
      }
    }
    if (!flag) answer[i] = "Rr";
  }

  return answer;
}
