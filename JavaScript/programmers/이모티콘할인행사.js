function solution(users, emoticons) {
  const answer = [0, 0];
  const rates = [10, 20, 30, 40];
  const len = emoticons.length;
  const res = [];
  const comb = (n, arr) => {
    if (n === len) {
      res.push([...arr]);
      return;
    }
    for (let i = 0; i < rates.length; i++) {
      arr[n] = rates[i];
      comb(n + 1, arr);
    }
  };
  comb(0, []);
  for (let i = 0; i < res.length; i++) {
    let sum = 0;
    let people = 0;
    for (const [p, v] of users) {
      let m = 0;
      for (let j = 0; j < res[i].length; j++) {
        if (p <= res[i][j]) {
          m += Math.floor(0.01 * (100 - res[i][j]) * emoticons[j]);
        }
      }
      if (m >= v) {
        people++;
      } else sum += m;
    }
    if (answer[0] < people) {
      answer[0] = people;
      answer[1] = sum;
    }
    if (answer[1] <= sum && people === answer[0]) {
      answer[1] = sum;
    }
  }

  return answer;
}
