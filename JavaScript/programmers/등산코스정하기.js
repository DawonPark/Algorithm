function solution(n, paths, gates, summits) {
  const graph = Array.from(new Array(n + 1), () => []);

  // 경로 리스트 설정
  paths.forEach(([from, to, weight]) => {
    graph[from].push([to, weight]);
    graph[to].push([from, weight]);
  });

  // 산봉우리에서는 다른 산봉우리로 가지못하도록 설정
  summits.forEach((submit) => (graph[submit] = []));

  // queue
  let queue = gates;

  const intensisties = new Array(n + 1).fill(Infinity);

  gates.forEach((v) => (intensisties[v] = -1));

  while (queue.length) {
    const set = new Set();
    while (queue.length) {
      const v = queue.pop(); // shift가 아닌 이유는 시간절약을 위해
      graph[v].forEach(([to, weight]) => {
        const max = Math.max(intensisties[v], weight);
        if (intensisties[to] > max) {
          intensisties[to] = max;
          set.add(to);
        }
      });
    }
    queue = [...set];
  }

  let ans = [-1, Infinity];
  let sort_summits = summits.sort((a, b) => a - b);

  for (let v of summits) {
    if (ans[1] > intensisties[v]) {
      ans[0] = v;
      ans[1] = intensisties[v];
    }
  }

  return ans;
}
