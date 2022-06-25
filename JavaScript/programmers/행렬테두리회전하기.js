let answer, map;
function solution(rows, columns, queries) {
  answer = [];
  map = Array.from(new Array(rows), () => new Array());
  let cnt = 0;
  for (let i = 0; i < rows; i++) {
    for (let j = 0; j < columns; j++) {
      map[i][j] = ++cnt;
    }
  }
  for (const arr of queries) rotation(arr);
  return answer;
}
function rotation(arr) {
  let [startRow, startCol, endRow, endCol] = arr;
  let temp = map[startRow - 1][startCol - 1];
  let min = temp;
  for (let i = startRow - 1; i < endRow; i++) {
    if (i === endRow - 1) {
      map[i][startCol - 1] = map[i][startCol];
      min = Math.min(min, map[i][startCol - 1]);
      break;
    }
    map[i][startCol - 1] = map[i + 1][startCol - 1];
    min = Math.min(min, map[i][startCol - 1]);
  }

  for (let i = startCol - 1; i < endCol; i++) {
    if (i === endCol - 1) {
      map[endRow - 1][i] = map[endRow - 2][i];
      min = Math.min(min, map[endRow - 1][i]);
      break;
    }
    map[endRow - 1][i] = map[endRow - 1][i + 1];
    min = Math.min(min, map[endRow - 1][i]);
  }
  for (let i = endRow - 2; i >= startRow - 1; i--) {
    if (i === startRow - 1) {
      map[i][endCol - 1] = map[i][endCol - 2];
      min = Math.min(min, map[i][endCol - 1]);
      break;
    }
    map[i][endCol - 1] = map[i - 1][endCol - 1];
    min = Math.min(min, map[i][endCol - 1]);
  }
  for (let i = endCol - 2; i > startCol; i--) {
    map[startRow - 1][i] = map[startRow - 1][i - 1];
    min = Math.min(min, map[startRow - 1][i]);
  }
  map[startRow - 1][startCol] = temp;
  answer.push(min);
}
