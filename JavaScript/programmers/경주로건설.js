function solution(board) {
  var answer = 0;
  const N = board.length;

  const visited = Array.from(new Array(N), () =>
    Array.from(new Array(N), () => new Array(4).fill(Infinity))
  );

  const dx = [0, 0, 1, -1];
  const dy = [1, -1, 0, 0];

  const queue = [
    [0, 0, 0, 0],
    [0, 0, 2, 0],
  ];

  while (queue.length) {
    const [x, y, dir, cost] = queue.shift();

    for (let d = 0; d < 4; d++) {
      const nx = x + dx[d];
      const ny = y + dy[d];
      if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
      if (board[nx][ny]) continue;

      const c = d === dir ? 100 : 600;

      if (visited[nx][ny][d] > cost + c) {
        visited[nx][ny][d] = cost + c;
        queue.push([nx, ny, d, cost + c]);
      }
    }
  }
  return visited[N - 1][N - 1].sort((a, b) => a - b)[0];
}
