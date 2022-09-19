function solution(cacheSize, cities) {
  let answer = 0;
  if (cacheSize === 0) return cities.length * 5;
  const cache = [];
  const count = [];
  // 1. 카운트 배열 이용
  // 2. 선택 될 시 0 으로 초기화 아니면 +1
  const upCount = (n) => {
    for (let i = 0; i < cache.length; i++) {
      if (n !== i) count[i]++;
    }
  };
  // 3. 삭제할 캐시 인덱스
  const deleteIndex = () => {
    let max = 0;
    let index = 0;
    for (let i = 0; i < count.length; i++) {
      if (max < count[i]) {
        max = count[i];
        index = i;
      }
    }
    return index;
  };

  for (const v of cities) {
    const city = v.toLowerCase();
    if (cache.includes(city)) {
      answer += 1;
      let index = cache.indexOf(city);
      count[index] = 0;
      upCount(index);
    } else {
      answer += 5;
      if (cache.length < cacheSize) {
        cache.push(city);
        count[cache.length - 1] = 0;
        upCount(cache.length - 1);
      } else {
        let index = deleteIndex();
        cache[index] = city;
        count[index] = 0;
        upCount(index);
      }
    }
  }
  return answer;
}
