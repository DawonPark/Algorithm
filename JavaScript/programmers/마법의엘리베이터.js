function solution(storey) {
  let answer = 0;
  while (storey !== 0) {
    const n = storey % 10;
    if (n > 5) {
      answer += 10 - n;
      storey = Math.floor(storey / 10) + 1;
    } else if (n === 5) {
      const a = Math.floor(storey / 10) % 10;
      if (a === 5 || a === 9) {
        storey = Math.floor(storey / 10) + 1;
      } else {
        storey = Math.floor(storey / 10);
      }
      answer += 5;
    } else {
      answer += n;
      storey = Math.floor(storey / 10);
    }
  }

  return answer;
}
