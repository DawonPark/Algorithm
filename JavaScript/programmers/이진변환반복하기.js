function solution(s) {
  let cnt = 0,
    rmCnt = 0;
  let str = s;

  let temp = 0;
  while (str !== "1") {
    let str2 = "";
    for (let ch of str) {
      if (ch === "1") {
        str2 = str2 + ch;
      } else {
        rmCnt++;
      }
    }
    cnt++;
    temp++;
    str = "" + +str2.toString(2).length.toString(2);
  }

  return [cnt, rmCnt];
}
