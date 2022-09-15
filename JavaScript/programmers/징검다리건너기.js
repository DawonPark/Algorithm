function solution(stones, k) {
  let left = 1;
  let right = 200000000;
  const go = (mid) => {
    let cnt = 0;
    for (let i = 0; i < stones.length; i++) {
      if (mid >= stones[i]) cnt++;
      else cnt = 0;
      if (cnt >= k) return false;
    }
    return true;
  };

  while (left <= right) {
    let mid = parseInt((left + right) / 2);
    if (go(mid)) left = mid + 1;
    else right = mid - 1;
  }
  return left;
}
