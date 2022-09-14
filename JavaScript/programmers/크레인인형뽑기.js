function solution(board, moves) {
  let answer = 0;
  let basket = [];

  // 인형을 뽑기 위한 함수
  const pick = (n) => {
    for (let i = 0; i < board[0].length; i++) {
      if (board[i][n - 1] !== 0) {
        let doll = board[i][n - 1];
        board[i][n - 1] = 0;
        return doll;
      }
    }
    return -1;
  };
  // 바스켓에 넣으면서 같을 시 카운팅 후 터트리기
  for (let i = 0; i < moves.length; i++) {
    let doll = pick(moves[i]);
    if (doll === -1) continue;
    if (basket[basket.length - 1] === doll) {
      // 같을 시 터트리기
      basket.pop();
      answer += 2;
    } else {
      // 같지 않으면 집어넣기
      basket.push(doll);
    }
  }

  return answer;
}
