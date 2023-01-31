function solution(x, y, n) {
  let answer = 0;
  let nubmers = {};
  let list = [x];
  nubmers[x] = 0;

  if (x === y) return 0;
  while (list.length != 0) {
    let new_list = [];
    answer++;
    for (let i of list) {
      for (let num of [i + n, i * 2, i * 3]) {
        if (num === y) return answer;
        if (num < y && !nubmers[num]) {
          nubmers[num] = answer;
          new_list.push(num);
        }
      }
    }
    list = new_list;
  }

  return -1;
}
