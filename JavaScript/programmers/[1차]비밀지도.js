function solution(n, arr1, arr2) {
  let res = Array.from(Array(n), () => new Array(n).fill("#"));
  let con1 = [];
  let con2 = [];
  for (let i = 0; i < n; i++) {
    const str1 = arr1[i].toString(2);
    const str2 = arr2[i].toString(2);
    con1[i] = "0".repeat(n - str1.length) + str1;
    con2[i] = "0".repeat(n - str2.length) + str2;
  }
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      if (con1[i][j] === "0" && con2[i][j] === "0") res[i][j] = " ";
    }
  }
  return res.map((v) => v.join(""));
}
