function solution(expression) {
  var answer = -Infinity;
  const op = [];
  const number = [];
  let num = "";

  for (let i = 0; i < expression.length; i++) {
    const ch = expression[i].charCodeAt(0);
    if ("0".charCodeAt(0) <= ch && ch <= "9".charCodeAt(0)) {
      num += expression[i];
    } else {
      number.push(parseInt(num));
      op.push(expression[i]);
      num = "";
    }
  }
  number.push(parseInt(num));

  const opArr = Array.from(new Set(op));

  const result = permutation(opArr, opArr.length);
  // console.log(result)
  for (let i = 0; i < result.length; i++) {
    let tempNumber = [...number];
    let tempOp = [...op];
    for (let j = 0; j < result[i].length; j++) {
      for (let k = 0; k < tempOp.length; k++) {
        let num = 0;
        if (tempOp[k] === result[i][j]) {
          if (tempOp[k] === "+") {
            tempNumber[k] += tempNumber[k + 1];
          } else if (tempOp[k] === "-") {
            tempNumber[k] -= tempNumber[k + 1];
          } else if (tempOp[k] === "*") {
            tempNumber[k] *= tempNumber[k + 1];
          }
          tempNumber.splice(k + 1, 1);
          tempOp.splice(k, 1);
          k--;
          // console.log(tempNumber ,tempOp);
        }
      }
    }
    answer = Math.max(answer, Math.abs(tempNumber[0]));
  }

  return answer;
}

function permutation(op, cnt) {
  let result = [];
  if (cnt === 1) return op.map((el) => [...el]);
  op.forEach((fixed, index, origin) => {
    const rest = [
      ...origin.slice(0, index),
      ...origin.slice(index + 1, origin.length),
    ];
    const permutaions = permutation(rest, cnt - 1);
    const attached = permutaions.map((el) => [fixed, ...el]);
    result.push(...attached);
  });
  return result;
}
