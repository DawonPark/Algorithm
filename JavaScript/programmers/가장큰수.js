function solution(numbers) {
  var answer = "";
  const arr = [];
  for (let i = 0; i < numbers.length; i++) {
    arr.push(numbers[i].toString());
  }

  arr.sort((a, b) => b + a - (a + b));
  for (let num of arr) {
    answer += num;
  }

  if (answer[0] === "0") return "0";

  return answer;
}
