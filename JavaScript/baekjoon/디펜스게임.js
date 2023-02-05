function solution(n, k, enemy) {
  let [left, right] = [0, enemy.length];
  let mid = Math.floor((left + right) / 2);
  while (left <= right) {
    const arr = enemy.slice(0, mid).sort((a, b) => b - a);
    let coupon = k;
    const curEnemy = arr.reduce((acc, cur) => {
      if (coupon > 0) {
        coupon--;
        return acc;
      }
      return acc + cur;
    }, 0);
    if (n - curEnemy >= 0 && coupon >= 0) {
      left = mid + 1;
    } else {
      right = mid - 1;
    }
    mid = Math.floor((left + right) / 2);
  }
  return left - 1;
}
