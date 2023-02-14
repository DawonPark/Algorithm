function solution(babbling) {
  let answer = 0;
  const arr = ["aya", "ye", "woo", "ma"];
  const can = [];
  const visited = new Array(4).fill(0);
  const per = (s, cnt, res, r) => {
    if (cnt === r) {
      let str = "";
      for (const i of res) {
        str += arr[i];
      }
      console.log(res);
      can.push(str);
      return res;
    }
    for (let i = 0; i < arr.length; i++) {
      if (visited[i]) continue;
      visited[i] = 1;
      res[cnt] = i;
      per(i + 1, cnt + 1, res, r);
      visited[i] = 0;
    }
  };
  per(0, 0, [], 1);
  per(0, 0, [], 2);
  per(0, 0, [], 3);
  per(0, 0, [], 4);
  for (const w of babbling) {
    for (const w2 of can) {
      if (w === w2) {
        answer++;
      }
    }
  }
  return answer;
}
