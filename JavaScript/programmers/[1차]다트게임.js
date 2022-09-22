function solution(dartResult) {
  let answer = [];
  let num = 0;
  for (let i = 0; i < dartResult.length; i++) {
    if ("0" <= dartResult[i] && dartResult[i] <= "9") {
      if (dartResult[i + 1] === "0") {
        num = 10;
        i++;
      } else num = parseInt(dartResult[i]);
    }
    if (dartResult[i] === "S") {
      answer.push(num);
    } else if (dartResult[i] === "D") {
      answer.push(num * num);
    } else if (dartResult[i] === "T") {
      answer.push(num * num * num);
    } else if (dartResult[i] === "*") {
      answer[answer.length - 1] *= 2;
      answer[answer.length - 2] *= 2;
    } else if (dartResult[i] === "#") {
      answer[answer.length - 1] *= -1;
    }
  }
  return answer.reduce((p, v) => p + v);
}
