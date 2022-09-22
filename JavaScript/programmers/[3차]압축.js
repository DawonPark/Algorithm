function solution(msg) {
  let answer = [];
  const map = new Map();

  for (let i = 0; i < 26; i++) {
    map.set(String.fromCharCode(65 + i), i + 1);
  }
  let idx = 26;

  for (let i = 0, p; i < msg.length; i = p) {
    let str = msg[i];
    p = i + 1;
    while (map.has(str) && p < msg.length) {
      let c = msg[p];
      if (!map.has(str + c)) {
        map.set(str + c, ++idx);
        break;
      }
      str += msg[p++];
    }
    answer.push(map.get(str));
  }

  return answer;
}
