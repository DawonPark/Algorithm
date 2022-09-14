function solution(s) {
  let answer = s[0].toUpperCase();
  let check = false;
  for (let i = 1; i < s.length; i++) {
    if (s[i] === " ") {
      answer += " ";
      check = true;
    } else {
      if (check) {
        answer += s[i].toUpperCase();
        check = false;
      } else answer += s[i].toLowerCase();
    }
  }
  return answer;
}
