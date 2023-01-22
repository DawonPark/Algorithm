function solution(weights) {
  let answer = 0;
  const map = new Map();
  for (const w of weights) {
    if (map.has(w)) {
      map.set(w, map.get(w) + 1);
    } else {
      map.set(w, 1);
    }
  }
  const rArr = [2, 4 / 3, 1.5];
  for (const [k, v] of map) {
    if (v > 1) answer += (v * (v - 1)) / 2;
    for (const r of rArr) {
      if (map.has(r * k)) answer += v * map.get(r * k);
    }
  }

  return answer;
}
