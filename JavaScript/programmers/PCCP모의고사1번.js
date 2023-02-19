function solution(input_string) {
  var answer = "";
  const arr = new Array(26).fill(0);
  let idx = 0;
  while (idx < input_string.length) {
    const s = input_string[idx];
    if (input_string[idx + 1] === s) {
      idx++;
      while (true) {
        if (input_string[idx + 1] === s) idx++;
        else break;
      }
      idx++;
      arr[s.charCodeAt(0) - "a".charCodeAt(0)]++;
    } else {
      arr[s.charCodeAt(0) - "a".charCodeAt(0)]++;
      idx++;
    }
  }
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] >= 2) answer += String.fromCharCode(97 + i);
  }

  return answer === "" ? "N" : answer;
}
