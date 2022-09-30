function solution(arr1, arr2) {
  var answer = [];
  for (let i = 0; i < arr1.length; i++) {
    const elem = [];
    for (let j = 0; j < arr2[0].length; j++) {
      let num = 0;
      for (let k = 0; k < arr1[0].length; k++) {
        num += arr1[i][k] * arr2[k][j];
      }
      elem.push(num);
    }
    answer.push(elem);
  }
  return answer;
}
