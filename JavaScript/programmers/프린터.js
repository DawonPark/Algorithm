function solution(priorities, location) {
  var answer = 0;
  const queue = [];
  for (let i = 0; i < priorities.length; i++) {
    queue.push({ loc: i, priority: priorities[i] });
  }
  outer: while (true) {
    let { loc, priority } = queue.shift();
    let size = queue.length;
    for (let i = 0; i < size; i++) {
      let { priority: check } = queue[i];
      if (check > priority) {
        queue.push({ loc, priority });
        continue outer;
      }
    }
    answer++;
    if (loc === location) return answer;
  }

  return answer;
}
