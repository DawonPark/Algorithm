function solution(numbers, hand) {
  var answer = [];
  const map = [
    [3, 1],
    [0, 0],
    [0, 1],
    [0, 2],
    [1, 0],
    [1, 1],
    [1, 2],
    [2, 0],
    [2, 1],
    [2, 2],
  ];
  let left = [3, 0];
  let right = [3, 2];
  for (const num of numbers) {
    if (num === 1 || num === 4 || num === 7) {
      answer.push("L");
      left = map[num];
    } else if (num === 3 || num === 6 || num === 9) {
      answer.push("R");
      right = map[num];
    } else {
      let p = map[num];
      let len1 = Math.abs(left[0] - p[0]) + Math.abs(left[1] - p[1]);
      let len2 = Math.abs(right[0] - p[0]) + Math.abs(right[1] - p[1]);
      if (len1 < len2) {
        answer.push("L");
        left = p;
      } else if (len2 < len1) {
        answer.push("R");
        right = p;
      } else if (len2 === len1) {
        if (hand === "right") {
          answer.push("R");
          right = p;
        } else {
          answer.push("L");
          left = p;
        }
      }
    }
  }
  return answer.join("");
}
