function solution(distance, scope, times) {
  let answer = 1;
  for (let i = 0; i < scope.length; i++) {
    const [a, b] = scope[i];
    scope[i][2] = i;
    if (a > b) {
      scope[i][0] = b;
      scope[i][1] = a;
    }
  }
  scope.sort((a, b) => {
    if (a[0] === b[0]) return a[1] - b[1];
    return a[0] - b[0];
  });
  let time = 1;
  outer: while (true) {
    for (let i = 0; i < scope.length; i++) {
      if (scope[i][0] <= answer && answer <= scope[i][1]) {
        const total = times[scope[i][2]][0] + times[scope[i][2]][1];
        if (time % total !== 0 && time % total <= times[scope[i][2]][0]) {
          break outer;
        }
      }
      if (answer > scope[i][1]) {
        scope.shift();
      }
    }
    answer++;
    time++;
    if (time >= distance) break;
  }
  return answer;
}
