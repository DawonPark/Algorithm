function solution(A, B) {
  let answer = 0;
  A = A.sort((a, b) => a - b);
  B = B.sort((a, b) => a - b);
  for (let i = 0; i < A.length; i++) {
    answer = answer + A[i] * B[B.length - 1 - i];
  }

  return answer;
}
