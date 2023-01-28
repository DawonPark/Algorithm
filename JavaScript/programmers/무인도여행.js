function solution(maps) {
  const answer = [];
  const visited = Array.from(new Array(maps.length), () =>
    new Array(maps[0].length).fill(0)
  );
  const dx = [0, 0, 1, -1];
  const dy = [1, -1, 0, 0];
  let max = 0;

  for (let i = 0; i < maps.length; i++) {
    for (let j = 0; j < maps[0].length; j++) {
      if (maps[i][j] === "X") {
        visited[i][j] = 1;
      } else {
        if (visited[i][j] === 1) continue;
        visited[i][j] = 1;
        let sum = parseInt(maps[i][j]);
        const queue = [[i, j]];
        while (queue.length) {
          const [x, y] = queue.pop();
          for (let d = 0; d < 4; d++) {
            const nx = x + dx[d];
            const ny = y + dy[d];
            if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length)
              continue;
            if (visited[nx][ny] || maps[nx][ny] === "X") continue;
            visited[nx][ny] = 1;
            sum += parseInt(maps[nx][ny]);
            queue.unshift([nx, ny]);
          }
        }
        answer.push(sum);
      }
    }
  }

  return answer.length === 0 ? [-1] : answer.sort((a, b) => a - b);
}
