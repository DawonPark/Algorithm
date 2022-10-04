function solution(fees, records) {
  const answer = [];
  const obj = {};
  const map = new Map();
  for (const record of records) {
    let arr = record.split(" ");
    if (arr[2] === "IN") {
      obj[arr[1]] = arr[0].split(":");
    } else {
      const number = arr[1];
      const outTime = arr[0].split(":");
      let time =
        (outTime[0] - obj[number][0]) * 60 + (outTime[1] - obj[number][1]);
      if (map.has(number)) {
        map.set(number, map.get(number) + time);
      } else {
        map.set(number, time);
      }
      delete obj[number];
    }
  }

  for (const number in obj) {
    let inTime = obj[number];
    let time = (23 - inTime[0]) * 60 + (59 - inTime[1]);
    if (map.has(number)) {
      map.set(number, map.get(number) + time);
    } else {
      map.set(number, time);
    }
  }

  let arr = Array.from(map);
  arr.sort((a, b) => a[0] - b[0]);
  for (const [number, time] of arr) {
    if (time <= fees[0]) {
      answer.push(fees[1]);
    } else {
      answer.push(fees[1] + Math.ceil((time - fees[0]) / fees[2]) * fees[3]);
    }
  }

  return answer;
}
