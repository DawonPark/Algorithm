function solution(lines) {
  let answer = 0;
  let times = [];
  lines.forEach((v) => {
    v = v.replace(/:/g, "").replace("s", "");
    let hour = v.slice(11, 13) * 3600;
    let min = v.slice(13, 15) * 60;
    let second = v.slice(15, 17) * 1;
    times.push("" + (hour + min + second) + v.slice(17));
  });

  for (let i = 0; i < times.length; i++) {
    const strArr = times[i].split(" ");
    const end = Number(strArr[0]) + 1;
    let cnt = 1;
    for (let j = i + 1; j < times.length; j++) {
      const strArr2 = times[j].split(" ");
      const start = Number(strArr2[0]) - Number(strArr2[1]) + 0.001;
      if (start < end) {
        cnt++;
      }
    }
    answer = Math.max(cnt, answer);
  }
  return answer;
}
