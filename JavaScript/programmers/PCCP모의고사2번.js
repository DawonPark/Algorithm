function solution(ability) {
  let answer = 0;
  const selectNum = ability[0].length;
  const visited = new Array(ability.length).fill(0);

  const dfs = (sum, n) => {
    if (n === selectNum) {
      answer = Math.max(sum, answer);
      return;
    }

    for (let i = 0; i < ability.length; i++) {
      if (visited[i]) continue;
      visited[i] = 1;
      sum += ability[i][n];
      dfs(sum, n + 1);
      sum -= ability[i][n];
      visited[i] = 0;
    }
  };
  dfs(0, 0);
  return answer;
}
