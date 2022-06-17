function bubbleSort(arr) {
  for (let i = arr.length; i > 0; i--) {
    for (let j = 0; j < i - 1; j++) {
      console.log(arr, arr[j], arr[j + 1]);
      if (arr[j] > arr[j + 1]) {
        let temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
      }
    }
  }
  return arr;
}
function bubbleSortCheck(arr) {
  let noSwaps;
  for (let i = arr.length; i > 0; i--) {
    for (let j = 0; j < i - 1; j++) {
      console.log(arr, arr[j], arr[j + 1]);
      if (arr[j] > arr[j + 1]) {
        let temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
        noSwaps = true;
      }
    }
    if (noSwaps) break;
  }
  return arr;
}
// bubbleSort([37, 45, 29, 8]);
// console.log(bubbleSort([37, 45, 29, 8]));
// console.log(bubbleSort([8, 1, 2, 3, 4, 5, 6, 7]));
console.log(bubbleSortCheck([8, 1, 2, 3, 4, 5, 6, 7]));
