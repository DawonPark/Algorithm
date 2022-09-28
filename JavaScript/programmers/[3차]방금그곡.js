function solution(m, musicinfos) {
  const answer = [];
  const convert = (str) => {
    return str
      .replace(/(C#)/g, "c")
      .replace(/(D#)/g, "d")
      .replace(/F#/g, "f")
      .replace(/G#/g, "g")
      .replace(/A#/g, "a");
  };
  m = convert(m);
  for (const music of musicinfos) {
    let [start, end, title, melody] = music.split(",");
    const [startH, startM] = start.split(":");
    const [endH, endM] = end.split(":");
    let time = (endH - startH) * 60 + (endM - startM);
    melody = convert(melody);
    if (melody.length > time) melody = melody.substring(0, time);
    else {
      const len = melody.length;
      for (let i = len; i < time; i++) {
        melody += melody[i % len];
      }
    }
    if (melody.includes(m)) {
      answer.push([title, time]);
    }
  }
  if (answer.length === 0) return "(None)";
  answer.sort((a, b) => b[1] - a[1]);
  return answer[0][0];
}
