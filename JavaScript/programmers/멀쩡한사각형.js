function solution(w, h) {
  let answer = 0;
  let count = 0;
  let start = 0;
  let [a, b] = [Math.min(w, h), Math.max(w, h)];
  let slope = a / b;
  let end = 0;
  while (count < b) {
    count++;
    end = slope * count;
    answer += Math.ceil(end) - start;
    start = Math.floor(end);
  }
  return w * h - answer;
}
