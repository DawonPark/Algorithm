function solution(skill, skill_trees) {
  let answer = 0;
  const arr = [];
  for (const skillTree of skill_trees) {
    const temp = [];
    for (const s of skill) {
      temp.push(skillTree.indexOf(s));
    }
    arr.push(temp);
  }
  outer: for (let i = 0; i < arr.length; i++) {
    let pre = arr[i][arr[0].length - 1];
    for (let j = arr[0].length - 2; j >= 0; j--) {
      if (pre !== -1 && arr[i][j] === -1) continue outer;
      if (pre !== -1 && pre < arr[i][j]) continue outer;
      pre = arr[i][j];
    }
    answer++;
  }

  return answer;
}
