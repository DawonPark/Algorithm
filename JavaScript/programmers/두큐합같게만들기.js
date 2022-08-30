function solution(queue1, queue2) {
  const array = [...queue1, ...queue2];
  const length = 2 * array.length;
  let sum = queue1.reduce((a, b) => a + b);
  let mid = array.reduce((a, b) => a + b) / 2;
  let start = 0;
  let end = queue1.length;
  let cnt = 0;
  while (true) {
    if (cnt >= length) {
      return -1;
    }
    if (sum > mid) {
      sum -= array[start];
      start++;
    } else if (sum < mid) {
      sum += array[end];
      end++;
    } else if (sum === mid) {
      // undefined 를 더하게 되면 NAN이 될 수있어 else는 불가능
      return cnt;
    }
    cnt++;
  }

  return -1;
}
