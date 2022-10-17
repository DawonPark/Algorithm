function solution(play_time, adv_time, logs) {
  // 100시간 -> 360000 초
  const convertTime = (str) => {
    const timeArr = str.split(":").map((v) => parseInt(v));
    const hour = timeArr[0] * 60 * 60;
    const min = timeArr[1] * 60;
    const second = timeArr[2];
    return hour + min + second;
  };

  play_time = convertTime(play_time);
  const adv = [0, convertTime(adv_time)];
  adv_time = adv[1];
  const arr = new Array(play_time + 1).fill(0);
  for (const log of logs) {
    let [start, end] = log.split("-");
    start = convertTime(start);
    end = convertTime(end);
    arr[start]++;
    arr[end]--;
  }

  for (let i = 1; i < play_time; i++) {
    arr[i] += arr[i - 1];
  }

  for (let i = 1; i < play_time; i++) {
    arr[i] += arr[i - 1];
  }

  let idx = 0;
  let sum = arr[adv_time - 1];
  for (let i = adv_time; i < play_time; i++) {
    if (sum < arr[i] - arr[i - adv_time]) {
      sum = arr[i] - arr[i - adv_time];
      adv[0] = [i - adv_time + 1];
      adv[1] = [i];
    }
  }

  let answer = "";
  let time = adv[0];
  let hour = Math.floor(time / 3600);
  time = time - hour * 3600;
  let min = Math.floor(time / 60);

  time = time - min * 60;
  if (hour < 10) {
    answer += "0" + hour;
  } else answer += hour;
  answer += ":";

  if (min < 10) {
    answer += "0" + min;
  } else answer += min;
  answer += ":";

  if (time < 10) {
    answer += "0" + time;
  } else answer += time;

  return answer;
}
