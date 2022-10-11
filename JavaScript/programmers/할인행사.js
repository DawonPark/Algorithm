function solution(want, number, discount) {
  let answer = 0;

  const map = new Map();
  const basket = new Map();

  for (let i = 0; i < want.length; i++) {
    map.set(want[i], number[i]);
  }

  const check = () => {
    for (const [k, v] of map) {
      if (basket.get(k) !== v) return;
    }
    answer++;
  };

  for (let i = 0; i < 10; i++) {
    if (basket.has(discount[i]))
      basket.set(discount[i], basket.get(discount[i]) + 1);
    else basket.set(discount[i], 1);
  }
  check();

  for (let i = 10; i < discount.length; i++) {
    if (basket.has(discount[i]))
      basket.set(discount[i], basket.get(discount[i]) + 1);
    else basket.set(discount[i], 1);
    if (basket.get(discount[i - 10]) === 1) basket.delete(discount[i - 10]);
    else basket.set(discount[i - 10], basket.get(discount[i - 10]) - 1);
    check();
  }

  return answer;
}
