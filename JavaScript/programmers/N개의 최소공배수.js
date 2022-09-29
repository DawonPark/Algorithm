function solution(arr) {
  let answer = arr[0];
  // 최대 공약수 구하기
  const gcd = (a, b) => {
    while (b > 0) {
      let temp = b;
      b = a % b;
      a = temp;
    }
    return a;
  };
  // 유클리드 호제법 두 수의 곱 / 최대공약수 = 최대 공배수
  const lcm = (a, b) => {
    return (a * b) / gcd(a, b);
  };

  for (let i = 1; i < arr.length; i++) {
    answer = lcm(answer, arr[i]);
  }
  return answer;
}
