function solution(n) {
  let answer = 0;
  const str = n.toString(2);
  let cnt = 0;
  for (const v of str) {
    if (v === "1") cnt++;
  }
  for (let i = n + 1; i <= 1000000; i++) {
    const str2 = i.toString(2);
    let cnt2 = 0;
    for (const v of str2) {
      if (v === "1") cnt2++;
    }
    if (cnt === cnt2) return i;
  }
  return answer;
}
