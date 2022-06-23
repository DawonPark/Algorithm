function solution(n) {
  var answer = "";
  let mapping = [4, 1, 2];
  while (n > 0) {
    answer = mapping[n % 3] + answer;
    if (n % 3 === 0) n--;
    n = Math.floor(n / 3);
  }
  return answer;
}
