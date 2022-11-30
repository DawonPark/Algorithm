function solution(topping) {
  let answer = 0;
  const dp1 = Array(topping.length).fill(0);
  const dp2 = Array(topping.length).fill(0);
  const list1 = new Set();
  for (let i = 0; i < topping.length; i++) {
    list1.add(topping[i]);
    dp1[i] = list1.size;
  }
  const list2 = new Set();
  list2.add(topping[topping.length - 1]);
  for (let i = topping.length - 1; i >= 0; i--) {
    list2.add(topping[i]);
    dp2[i] = list2.size;
  }

  for (let i = 0; i < topping.length - 1; i++) {
    if (dp1[i] === dp2[i + 1]) answer++;
  }
  return answer;
}
