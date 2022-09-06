function solution(str1, str2) {
  var answer = 0;
  let s1 = str1.toUpperCase();
  let s2 = str2.toUpperCase();
  let list1 = [];
  let list2 = [];
  for (let i = 0; i < s1.length - 1; i++) {
    if (
      "A".charCodeAt(0) <= s1.charCodeAt(i) &&
      s1.charCodeAt(i) <= "Z".charCodeAt(0) &&
      "A".charCodeAt(0) <= s1.charCodeAt(i + 1) &&
      s1.charCodeAt(i + 1) <= "Z".charCodeAt(0)
    ) {
      list1.push(s1.slice(i, i + 2));
    }
  }
  for (let i = 0; i < s2.length - 1; i++) {
    if (
      "A".charCodeAt(0) <= s2.charCodeAt(i) &&
      s2.charCodeAt(i) <= "Z".charCodeAt(0) &&
      "A".charCodeAt(0) <= s2.charCodeAt(i + 1) &&
      s2.charCodeAt(i + 1) <= "Z".charCodeAt(0)
    ) {
      list2.push(s2.slice(i, i + 2));
    }
  }
  let inter = 0;

  for (let i = 0; i < list1.length; i++) {
    for (let j = 0; j < list2.length; j++) {
      if (list1[i] === list2[j]) {
        list2.splice(j, 1);
        inter++;
        break;
      }
    }
  }
  let set = list1.length + list2.length;

  if (set === 0) return 65536;
  answer = Math.floor((inter / set) * 65536);
  return answer;
}
