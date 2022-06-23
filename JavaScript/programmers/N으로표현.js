let n, num, answer;
function solution(N, number) {
  answer = Infinity;
  n = N;
  num = number;

  dfs(0, 0);
  return answer === Infinity ? -1 : answer;
}

function dfs(count, sum) {
  if (sum === num) {
    answer = Math.min(answer, count);
    return;
  }

  let temp = n;
  for (let i = 0; i < 8 - count; i++) {
    let newCount = count + i + 1;
    dfs(newCount, sum + temp);
    dfs(newCount, sum - temp);
    dfs(newCount, Math.floor(sum / temp));
    dfs(newCount, sum * temp);
    temp = 10 * temp + n;
  }
}
