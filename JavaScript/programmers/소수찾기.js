const result = new Set();
function solution(numbers) {
  let answer = [];

  subset(numbers, 0, "");
  const arr = Array.from(result);
  for (let i = 0; i < arr.length; i++) {
    const resArr = arr[i].split("");
    const perArr = permutation(resArr, resArr.length);
    for (let j = 0; j < perArr.length; j++) {
      let str = "";
      for (const num of perArr[j]) {
        str += num;
      }
      if (isDemical(Number(str))) {
        answer.push(Number(str));
      }
    }
  }
  answer = new Set(answer);
  return answer.size;
}

function permutation(num, cnt) {
  let result = [];
  if (cnt === 1) return num.map((el) => [el]);
  num.forEach((fixed, index, origin) => {
    let rest = [...origin.slice(0, index), ...origin.slice(index + 1)];
    let permutaitions = permutation(rest, cnt - 1);
    let attached = permutaitions.map((el) => [fixed, ...el]);
    result.push(...attached);
  });
  return result;
}

function subset(numbers, length, res) {
  if (length === numbers.length) {
    if (res) result.add(res);
    return;
  }
  subset(numbers, length + 1, res + numbers[length]);
  subset(numbers, length + 1, res);
}

function isDemical(number) {
  if (number === 0 || number === 1) return false;
  for (let i = 2; i < number; i++) {
    if (number % i === 0) return false;
  }
  return true;
}
