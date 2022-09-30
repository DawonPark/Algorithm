function solution(n) {
  let ans = 0;
  while (n > 0) {
    ans += n % 2;
    n = parseInt(n / 2);
  }
  return ans;
}
