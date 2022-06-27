function solution(orders, course) {
  let answer = [];
  let map = new Map();
  for (let i = 0; i < orders.length; i++) {
    for (let j = 0; j < course.length; j++) {
      const sorted = orders[i].split("").sort();
      const arr = combination(sorted, course[j]);

      if (arr.length > 0) {
        for (const el of arr) {
          let str = "";
          for (const s of el) {
            str += s;
          }
          if (map.has(str)) {
            map.set(str, map.get(str) + 1);
          } else {
            map.set(str, 1);
          }
        }
      }
    }
  }

  let max = [];
  for (const el of course) {
    let cnt = 0;
    map.forEach((value, key) => {
      if (key.length === el) cnt = Math.max(cnt, value);
    });
    max[el] = cnt;
  }
  map.forEach((value, key) => {
    if (max[key.length] === value && value >= 2) answer.push(key);
  });
  console.log(answer.sort());
  return answer;
}

function combination(arr, count) {
  const result = [];
  if (count === 1) return arr.map((el) => [el]);
  arr.forEach((fixed, index, origin) => {
    const rest = origin.slice(index + 1);
    const cominations = combination(rest, count - 1);
    const attached = cominations.map((el) => [fixed, ...el]);
    result.push(...attached);
  });
  return result.sort();
}
