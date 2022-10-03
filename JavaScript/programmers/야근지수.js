function solution(n, works) {
  let answer = 0;
  works.sort((a, b) => a - b);

  while (n) {
    const max = works[works.length - 1];
    for (let i = works.length - 1; i >= 0; i--) {
      if (works[i] >= max) {
        works[i]--;
        n--;
      }
      if (!n) break;
    }
  }

  for (const n of works) {
    if (n > 0) answer += Math.pow(n, 2);
  }
  return answer;
}
