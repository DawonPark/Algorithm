function solution(record) {
  let answer = [];
  const map = new Map();
  // uid에 대한 마지막 아이디를 설정하기 위해 Map을 사용
  for (const message of record) {
    const arr = message.split(" ");
    if (arr[0] === "Enter" || arr[0] === "Change") {
      map.set(arr[1], arr[2]); // 아이디가 변경되는 조건은 Enter와 Change에 변경
    }
  }
  // 마지막 채팅메세지 설정
  for (const message of record) {
    const arr = message.split(" ");
    if (arr[0] === "Enter") {
      answer.push(`${map.get(arr[1])}님이 들어왔습니다.`);
    } else if (arr[0] === "Leave") {
      answer.push(`${map.get(arr[1])}님이 나갔습니다.`);
    }
  }

  return answer;
}
