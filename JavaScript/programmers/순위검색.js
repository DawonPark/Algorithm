function solution(info, query) {
  let answer = [];
  let map = {};
  function subset(arr, cnt, answer, num) {
    if (cnt === 4) {
      if (map[answer]) {
        map[answer].push(num);
      } else {
        map[answer] = [num];
      }
      return;
    }
    subset(arr, cnt + 1, answer + arr[cnt], num);
    subset(arr, cnt + 1, answer + "-", num);
  }

  function binarySearch(querys, num) {
    let arr = map[querys.trim()];
    if (arr) {
      let [l, r] = [0, arr.length - 1];
      let mid;
      while (l <= r) {
        mid = Math.floor((l + r) / 2);
        if (num <= arr[mid]) {
          r = mid - 1;
        } else {
          l = mid + 1;
        }
        if (num === arr[mid]) {
          l = mid;
          break;
        }
      }
      // console.log(mid, r , l , arr.length);
      return arr.length - l;
    } else {
      return 0;
    }
  }

  for (let i = 0; i < info.length; i++) {
    let infos = info[i].split(" ");
    let [str, num] = [infos.slice(0, 4), Number(infos.slice(-1))];
    subset(infos, 0, "", num);
  }
  for (key in map) {
    map[key].sort((a, b) => a - b);
  }

  for (let i = 0; i < query.length; i++) {
    let querys = query[i].replace(/[0-9]/g, "").split(" and ").join("");
    let num = query[i].replace(/[a-z | -]/g, "");
    answer.push(binarySearch(querys, num));
  }

  return answer;
}
