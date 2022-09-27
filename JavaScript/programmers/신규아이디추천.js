function solution(new_id) {
  let answer = "";
  // 1. 소문자 치환
  answer = new_id.toLowerCase();
  // 2. 소문자, 숫자, - , _, . 제외 문자 제거
  answer = answer.split("");
  for (let i = 0; i < answer.length; i++) {
    let ch = answer[i];
    if (
      ("0" <= ch && ch <= "9") ||
      ("a" <= ch && ch <= "z") ||
      ch === "-" ||
      ch === "_" ||
      ch === "."
    )
      continue;
    answer[i] = "";
  }
  // 3. . 2번이상 연속된 부분 .
  answer = answer.join("").split("");
  for (let i = 0; i < answer.length; i++) {
    if (answer[i] === ".") {
      let idx = i + 1;
      for (let j = i + 1; j < answer.length; j++) {
        if (answer[j] !== ".") break;
        idx++;
      }
      for (let j = i + 1; j < idx; j++) {
        answer[j] = "";
      }
    }
  }
  // 4. .가 처음이나 끝에 위치한다면 제거
  answer = answer.join("").split("");

  if (answer[0] === ".") answer[0] = "";
  if (answer[answer.length - 1] === ".") answer[answer.length - 1] = "";

  // 5. 빈문자열이라면 "a" 대입
  answer = answer.join("");
  if (!answer) answer = "a";

  // 6. 16자 이상이면 15개 문자 제외 마지막 문자가 .이라면 . 제거
  if (answer.length >= 15) answer = answer.slice(0, 15);
  let idx = answer.length - 1;
  for (let i = answer.length - 1; i >= 0; i--) {
    if (answer[i] === ".") idx--;
    else break;
  }
  answer = answer.slice(0, idx + 1);

  // 7. 2자 이하라면 3이 될때까지 반복
  if (answer.length <= 2) {
    answer = answer.split("");
    const ch = answer[answer.length - 1];
    for (let i = answer.length; i < 3; i++) {
      answer[i] = ch;
    }
    answer = answer.join("");
  }
  return answer;
}
