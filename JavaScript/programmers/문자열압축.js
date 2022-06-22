function solution(s) {
  let answer = s.length;
  let half = Math.floor(s.length / 2);
  // 등호가 필요한 이유는 slice 마지막은 잘리지 않음
  for (let i = 1; i <= half; i++) {
    let temp = s.slice(0, i); // 초기 비교값
    let comp = ""; // 압축 문자열 저장
    let cnt = 1; // 압축 개수를 저장하는 변수
    // 처음부터 개수 크기만큼 확인
    for (let j = i; j < s.length; j += i) {
      if (temp === s.slice(j, j + i)) {
        cnt++; // 비교 문자열과 같다면 카운터 증가 후 다음으로
      } else {
        // 다르다면 압축 문자열에 저장 -> 1 이상이면 압축이므로 cnt를 붙여줌
        if (cnt > 1) comp += cnt + temp;
        else comp += temp;
        temp = s.slice(j, j + i);
        cnt = 1;
      }
    }

    if (cnt > 1) comp += cnt + temp;
    else comp += temp;

    answer = Math.min(answer, comp.length);
  }

  return answer;
}
