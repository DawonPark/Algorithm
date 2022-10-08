function solution(A, B) {
  let answer = 0;
  A.sort((a, b) => b - a);
  B.sort((a, b) => b - a);

  let p = 0;
  for (let i = 0; i < B.length; i++) {
    if (p >= B.length) break;
    if (B[p] > A[i]) {
      answer++;
      p++;
    }
  }

  return answer;
}
