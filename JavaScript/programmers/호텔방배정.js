function solution(k, room_number) {
  let answer = [];
  const map = new Map();
  const allocateRoom = (n) => {
    if (!map.has(n)) {
      map.set(n, n + 1);
      return n;
    }
    let room = allocateRoom(map.get(n));
    map.set(n, room + 1);
    return room;
  };

  for (const room of room_number) {
    answer.push(allocateRoom(room));
  }

  return answer;
}
