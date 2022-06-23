let answer = 0;
let nums, tar, N;
function solution(numbers, target) {
  nums = numbers;
  tar = target;
  N = numbers.length;
  dfs(0, 0);
  return answer;
}

function dfs(cnt, sum) {
  if (cnt === N) {
    if (sum === tar) answer++;
    return;
  }
  dfs(cnt + 1, sum + nums[cnt]);
  dfs(cnt + 1, sum - nums[cnt]);
}
