function solution(n) {
  let answer = 0;
  for (let i = n; i >= 0; i--) {
    let sum = i;
    for (let j = i - 1; j >= 0; j--) {
      if (sum === n) {
        answer++;
        break;
      } else if (sum > n) break;
      sum += j;
    }
  }
  return answer;
}
