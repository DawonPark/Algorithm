function solution(progresses, speeds) {
  var answer = [];
  let queue = [];
  for (let i = 0; i < progresses.length; i++) {
    queue.push({ progress: progresses[i], speed: speeds[i] });
  }
  let cnt = 0;
  while (queue.length) {
    let { progress, speed } = queue[0];

    if (progress >= 100) {
      let cnt;
      for (cnt = 0; cnt < queue.length; cnt++) {
        if (queue[cnt].progress >= 100) continue;
        break;
      }
      answer.push(cnt);
      while (cnt !== 0) {
        queue.shift();
        cnt--;
      }
    } else {
      for (let i = 0; i < queue.length; i++) {
        queue[i].progress += queue[i].speed;
      }
    }
  }
  return answer;
}
