function solution(n, t, m, p) {
  let answer = "";
  let num = 0,
    str = "";
  while (str.length < t * m) {
    str += num.toString(n).toUpperCase();
    num++;
  }
  for (let i = p - 1; i < t * m; i += m) {
    answer += str[i];
  }
  return answer;
}
