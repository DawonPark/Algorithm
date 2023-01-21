function solution(data, col, row_begin, row_end) {
  let answer = 0;
  data.sort((a, b) => {
    if (a[col - 1] === b[col - 1]) return b[0] - a[0];
    return a[col - 1] - b[col - 1];
  });

  for (let i = row_begin; i <= row_end; i++) {
    let sum = 0;
    for (let d of data[i - 1]) {
      sum += d % i;
    }
    answer ^= sum;
  }

  return answer;
}
