function solution(arr) {
  const answer = [0, 0];

  const solve = (p, len) => {
    let n = arr[p[0]][p[1]];
    if (len === 1) {
      n === 0 ? answer[0]++ : answer[1]++;
      return;
    }

    let flag = true;

    outer: for (let i = p[0]; i < p[0] + len; i++) {
      for (let j = p[1]; j < p[1] + len; j++) {
        if (n !== arr[i][j]) {
          flag = false;
          break outer;
        }
      }
    }

    if (flag) {
      n === 0 ? answer[0]++ : answer[1]++;
      return;
    }
    let half = len / 2;
    solve([p[0], p[1]], half);
    solve([p[0] + half, p[1]], half);
    solve([p[0], p[1] + half], half);
    solve([p[0] + half, p[1] + half], half);
  };

  solve([0, 0], arr.length);

  return answer;
}
