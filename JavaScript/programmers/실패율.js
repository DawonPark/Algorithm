function solution(N, stages) {
  let n = stages.length;
  let arr = [];
  let idx = 0;
  stages.sort((a, b) => a - b);

  for (let i = 1; i <= N; i++) {
    let cnt = 0;
    for (let j = idx; j <= stages.length; j++) {
      if (i === stages[j]) {
        idx = j;
        cnt++;
      }
    }
    arr.push([i, cnt / n]);
    n -= cnt;
  }

  arr.sort((a, b) => b[1] - a[1]);
  return arr.map((v) => v[0]);
}
