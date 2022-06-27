function solution(p) {
  if (p === "") return "";

  let flag = true;
  const stack = [];
  if (p[0] === ")") {
    flag = false;
  } else {
    stack.push(p[0]);
    for (let i = 1; i < p.length; i++) {
      if (p[i] === "(") stack.push(p[i]);
      else {
        if (stack.length) stack.pop();
        else {
          flag = false;
          break;
        }
      }
    }
  }
  if (flag) return p;
  // console.log(solve(p));
  return solve(p);
}
function solve(p) {
  let answer = "";
  if (p === "") return "";
  let l = 0;
  let r = 0;
  let u, v;
  for (let i = 0; i < p.length; i++) {
    if (p[i] === "(") l++;
    else r++;
    if (l === r) {
      u = p.slice(0, i + 1);
      v = p.slice(i + 1, p.length);
      break;
    }
  }

  let flag = true;
  const stack = [];
  if (u[0] === ")") {
    flag = false;
  } else {
    stack.push(u[0]);
    for (let i = 1; i < u.length; i++) {
      if (u[i] === "(") stack.push(u[i]);
      else {
        if (stack.length) stack.pop();
        else {
          flag = false;
          break;
        }
      }
    }
  }
  if (flag) {
    answer = u + solve(v);
  } else {
    answer = "(";
    answer = answer + solve(v) + ")";
    for (let i = 1; i < u.length - 1; i++) {
      if (u[i] === "(") {
        answer += ")";
      } else {
        answer += "(";
      }
    }
  }
  return answer;
}
