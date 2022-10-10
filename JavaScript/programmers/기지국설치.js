function solution(n, stations, w) {
  let answer = 0;
  let p = 1;
  let i = 0;

  while (p <= n) {
    if (stations[i] - w <= p && p <= stations[i] + w) {
      p = stations[i] + w + 1;
      i++;
    } else {
      p += 2 * w + 1;
      answer++;
    }
  }

  return answer;
}
