function solution(s) {
  let answer = [];
  let str = s.slice(1, s.length - 1);
  let arr = [];
  let cnt = 0;
  let [idx, pre] = [0, 1];
  while (idx < str.length) {
    if (str[idx] === "}") {
      arr[cnt++] = str
        .slice(pre, idx)
        .split(",")
        .map((el) => parseInt(el));
      pre = idx + 3;
    }
    idx++;
  }
  arr.sort((a, b) => a.length - b.length);
  for (let i = 0; i < arr.length; i++) {
    for (let j = 0; j < arr[i].length; j++) {
      if (!answer.includes(arr[i][j])) {
        answer.push(arr[i][j]);
        break;
      }
    }
  }
  return answer;
}
