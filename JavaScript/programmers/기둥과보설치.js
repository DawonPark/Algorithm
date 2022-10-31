function solution(n, build_frame) {
  var answer = [];
  // 0 기둥 , 1 보  / 0 삭제 , 1 설치
  // [1,0,0,1],[1,1,1,1]
  const pillar = Array.from(Array(n + 1), () => new Array(n + 1).fill(0));
  const carpet = Array.from(Array(n + 1), () => new Array(n + 1).fill(0));

  const check = (r, c, type) => {
    if (type === 0) {
      // 기둥
      if (r === n) return true; // 바닥
      if (pillar[r + 1][c]) return true; // 기둥 위에 세우기
      if (carpet[r][c] || (c > 0 && carpet[r][c - 1])) return true;
    } else {
      // 보
      if (
        (r < n && pillar[r + 1][c]) ||
        (r < n && c < n && pillar[r + 1][c + 1])
      )
        return true; // 기둥 위에
      if (c > 0 && carpet[r][c - 1] && c < n && carpet[r][c + 1]) return true;
    }
    return false;
  };

  const destory = () => {
    for (let i = 0; i <= n; i++) {
      for (let j = 0; j <= n; j++) {
        if (pillar[i][j]) {
          if (!check(i, j, 0)) return false;
        }
        if (carpet[i][j]) {
          if (!check(i, j, 1)) return false;
        }
      }
    }
    return true;
  };

  for (const build of build_frame) {
    let [c, r, a, b] = build;
    r = n - r;
    if (b === 1) {
      if (check(r, c, a)) {
        if (a === 0) pillar[r][c] = 1;
        else carpet[r][c] = 1;
      }
    } else {
      if (a === 0) {
        pillar[r][c] = 0;
        if (!destory()) pillar[r][c] = 1;
      } else {
        carpet[r][c] = 0;
        if (!destory()) carpet[r][c] = 1;
      }
    }
  }

  for (let i = 0; i <= n; i++) {
    for (let j = 0; j <= n; j++) {
      if (pillar[n - j][i]) answer.push([i, j, 0]);
      if (carpet[n - j][i]) answer.push([i, j, 1]);
    }
  }

  return answer;
}
