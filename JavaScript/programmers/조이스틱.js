function solution(name) {
  var answer = 0;
  let move = Infinity;
  for (let i = 0; i < name.length; i++) {
    let aCharCode = "A".charCodeAt(0);
    let zCharCode = "Z".charCodeAt(0);
    let currentCharCode = name[i].charCodeAt(0);
    answer += Math.min(
      Math.abs(currentCharCode - aCharCode),
      Math.abs(currentCharCode - zCharCode - 1)
    );
    let index = i + 1;
    while (index < name.length && name[index] === "A") {
      index++;
    }
    move = Math.min(move, (name.length - index) * 2 + i);
    move = Math.min(move, i * 2 + name.length - index);
  }
  return answer + move;
}
