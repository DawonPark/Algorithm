function solution(cards) {
  let answer = 0;
  cards.unshift(0);

  const dfs = (num, visited, type) => {
    if (visited[num]) return;
    visited[num] = type;
    dfs(cards[num], visited, type);
  };

  for (let i = 1; i < cards.length; i++) {
    const visited = Array(cards.length).fill(0);
    dfs(cards[i], visited, 1);
    let cnt1 = 0;
    for (const v of visited) {
      if (v === 1) cnt1++;
    }
    if (cnt1 === cards.length - 1) continue;
    for (let j = 1; j < cards.length; j++) {
      if (visited[j]) continue;
      const visited2 = [...visited];
      dfs(cards[j], visited2, 2);
      let cnt2 = 0;
      for (const v of visited2) {
        if (v === 2) cnt2++;
      }
      answer = Math.max(answer, cnt1 * cnt2);
    }
  }
  return answer;
}
