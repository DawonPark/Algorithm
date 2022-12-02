function solution(k, tangerine) {
  let answer = 0;
  const arr = Array(10000001).fill(0);
  for (const v of tangerine) {
    arr[v]++;
  }
  arr.sort((a, b) => b - a);
  let num = 0;
  for (let i = 0; i <= 10000000; i++) {
    num += arr[i];
    if (num >= k) return i + 1;
  }
  return answer;
}
