function solution(rectangle, characterX, characterY, itemX, itemY) {
  const map = Array.from(Array(101), () => Array(101).fill(0)); //  X, Y는 50 이하의 자연수
  const doubleRectangle = rectangle.map((v) => v.map((p) => 2 * p)); // 주어진 꼭짓점들 * 2

  doubleRectangle.forEach(([x1, y1, x2, y2]) => {
    for (let i = x1; i <= x2; i++) {
      for (let j = y1; j <= y2; j++) {
        if (i === x1 || i === x2 || j === y1 || j === y2) {
          if (map[i][j] !== 1) map[i][j] += 1; // 2인 경우도 고려해야하므로 +1
        } else {
          map[i][j] = 2; // 안쪽 넓이면 2
        }
      }
    }
  });

  const dx = [0, 0, 1, -1];
  const dy = [1, -1, 0, 0];

  const queue = [[characterX * 2, characterY * 2, 0]];
  map[characterX * 2][characterY * 2] = 0;
  while (queue.length) {
    const [x, y, cnt] = queue.shift();

    if (x === itemX * 2 && y === itemY * 2) {
      return cnt / 2;
    }

    for (let d = 0; d < 4; d++) {
      const nx = x + dx[d];
      const ny = y + dy[d];
      if (nx < 0 || nx >= 101 || ny < 0 || ny >= 101) continue;
      if (map[nx][ny] === 1) {
        map[nx][ny] = 0;
        queue.push([nx, ny, cnt + 1]);
      }
    }
  }
}
