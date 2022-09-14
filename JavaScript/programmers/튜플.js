function solution(s) {
  let answer = [];
  let string = s.slice(1, s.length - 1); // 맨 앞과 뒤 제거
  let pre = 0;
  let arr = [];
  // } 를 기점으로 잘라준 후 ,를 구분자로 다시 자르면 됨
  for (let i = 0; i < string.length; i++) {
    if (string[i] === "}") {
      arr.push(string.slice(pre + 1, i).split(","));
      pre = i + 2;
    }
  }
  // 원소 개수를 기준으로 정렬
  arr.sort((a, b) => a.length - b.length);

  for (const v of arr) {
    for (let s of v) {
      if (answer.includes(+s)) continue;
      else answer.push(+s);
    }
  }

  return answer;
}
