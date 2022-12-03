function solution(arrayA, arrayB) {
  var answer = 0;
  arrayA.sort((a, b) => a - b);
  arrayB.sort((a, b) => a - b);
  const end = Math.max(arrayA[0], arrayB[0]);
  const check = (num, arr1, arr2) => {
    for (let i = 0; i < arr1.length; i++) {
      if (arr1[i] % num !== 0) return false;
    }
    for (let i = 0; i < arr2.length; i++) {
      if (arr2[i] % num === 0) return false;
    }
    return true;
  };
  for (let i = end; i >= 1; i--) {
    if (check(i, arrayA, arrayB)) {
      return i;
    }
    if (check(i, arrayB, arrayA)) {
      return i;
    }
  }
  return answer;
}
