function solution(files) {
  let parseFile = [];
  for (let i = 0; i < files.length; i++) {
    const arr = ["", "", ""];
    for (let j = 0; j < files[i].length; j++) {
      const flag = isNaN(parseInt(files[i][j]));
      if (flag && !arr[1].length) {
        arr[0] += files[i][j];
      } else if (!flag && !arr[2].length) {
        arr[1] += files[i][j];
      } else {
        arr[2] += files[i][j];
      }
    }
    parseFile.push(arr);
  }

  parseFile.sort((a, b) => {
    const stringA = a[0].toUpperCase(),
      stringB = b[0].toUpperCase();
    if (stringA > stringB) {
      return 1;
    } else if (stringA < stringB) {
      return -1;
    } else {
      const numberA = parseInt(a[1]),
        numberB = parseInt(b[1]);
      return numberA - numberB;
    }
  });

  return parseFile.map((v) => v.join(""));
}
