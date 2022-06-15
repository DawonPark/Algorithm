const sumZero = (arr) => {
  let left = 0;
  let right = arr.length - 1;
  while (left < right) {
    if (arr[left] + arr[right] === 0) {
      return [arr[left], arr[right]];
    } else if (arr[left] + arr[right] > 0) {
      right--;
    } else {
      left++;
    }
  }
};

const countUniqueValues = (arr) => {
  if (arr.length <= 0) return 0;
  let p1 = 0;
  let p2 = 0;
  let ans = 1;
  while (p2 < arr.length) {
    if (arr[p1] === arr[p2]) {
      p2++;
    } else {
      p1 = p2;
      p2++;
      ans++;
    }
  }
  return ans;
};

// const countUniqueValues = (arr) => {
//     if (arr.length <= 0) return 0;
//     let p1 = 0;
//     let p2 = 0;
//     let ans = 1;
//     while (p2 < arr.length) {
//         if (arr[p1] === arr[p2]) {
//             p2++;
//         } else {
//             p1++;
//             arr[p1] = arr[p2];
//             p2++;
//             ans++;
//         }
//     }
//     return p1 === 0 ? p1 : p1 + 1;
// };
console.log(sumZero([-4, -3, -2, -1, 0, 10]));
console.log(countUniqueValues([1, 1, 1, 1, 1, 2]));
console.log(countUniqueValues([1, 2, 3, 4, 4, 4, 7, 7, 12, 12, 13]));
console.log(countUniqueValues([]));
console.log(countUniqueValues([-2, -1, -1, 0, 1]));
