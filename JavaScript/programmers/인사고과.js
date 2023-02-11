function solution(scores) {
  const m = scores[0];

  scores.sort((a, b) => (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));

  const v = [];
  let max = 0;
  for (const [a, b] of scores) {
    if (b < max) {
      if (a == m[0] && b == m[1]) return -1;
    } else {
      v.push(a + b);
      max = Math.max(max, b);
    }
  }

  v.sort((a, b) => b - a);

  let lo = 0;
  let hi = v.length - 1;
  let sum = m[0] + m[1];

  while (lo <= hi) {
    let mid = Math.floor((lo + hi) / 2);
    if (v[mid] <= sum) hi = mid - 1;
    else lo = mid + 1;
  }

  return hi + 2;
}
