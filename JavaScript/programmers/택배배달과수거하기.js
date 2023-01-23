function solution(cap, n, deliveries, pickups) {
  var answer = 0;
  let dIdx = n - 1;
  let pIdx = n - 1;
  const check = () => {
    for (let i = 0; i < n; i++) {
      if (deliveries[i]) return false;
      if (pickups[i]) return false;
    }
    return true;
  };

  const pick = () => {
    let box = cap;
    let idx = -1;
    for (let i = pIdx; i >= 0; i--) {
      if (pickups[i]) {
        if (box > pickups[i]) {
          box -= pickups[i];
          pickups[i] = 0;
          if (idx === -1) idx = i;
        } else {
          pickups[i] -= box;
          pIdx = idx === -1 ? i : idx;
          return idx === -1 ? i : idx;
        }
      }
    }
    return idx;
  };

  const del = () => {
    let box = cap;
    let idx = -1;
    for (let i = dIdx; i >= 0; i--) {
      if (deliveries[i]) {
        if (box > deliveries[i]) {
          box -= deliveries[i];
          deliveries[i] = 0;
          if (idx === -1) idx = i;
        } else {
          deliveries[i] -= box;
          dIdx = idx === -1 ? i : idx;
          return idx === -1 ? i : idx;
        }
      }
    }
    return idx;
  };

  while (!check()) {
    let idx1 = del();
    let idx2 = pick();
    if (idx1 > idx2) {
      answer += idx1 * 2 + 2;
    } else {
      answer += idx2 * 2 + 2;
    }
  }

  return answer;
}
