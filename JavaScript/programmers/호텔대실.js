function solution(book_time) {
  let answer = 0;
  // 60 * 60 * 24
  const arr = new Array(86401).fill(0);
  const convert = (s) => {
    let [startH, startM] = s[0].split(":");
    let [endH, endM] = s[1].split(":");
    const startS = parseInt(startH) * 60 * 60 + parseInt(startM) * 60;
    const endS = parseInt(endH) * 60 * 60 + parseInt(endM) * 60 + 600 - 1;
    for (let i = startS; i < endS; i++) {
      arr[i]++;
    }
  };
  for (const b of book_time) {
    convert(b);
  }
  for (let i = 1; i < 86401; i++) {
    answer = Math.max(answer, arr[i]);
  }

  return answer;
}
