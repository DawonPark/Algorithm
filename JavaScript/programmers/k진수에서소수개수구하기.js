function solution(n, k) {
  var answer = 0;

  const isPrime = (n) => {
    if (n === 0) return false;
    if (n === 1) return false;
    for (let i = 2; i <= Math.sqrt(n); i++) {
      if (n % i === 0) return false;
    }
    return true;
  };

  const kNum = n.toString(k);
  const arr = kNum.split("0");
  for (const num of arr) {
    if (isPrime(Number(num))) answer++;
  }

  return answer;
}
