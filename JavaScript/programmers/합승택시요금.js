function solution (n, s, a, b, fares) {
    const map = Array.from(Array(n) , ()=> Array(n).fill(Infinity));
  
    for(let i = 0; i < n; i++){
        map[i][i] = 0;
    }
  
    fares.forEach(v => {
        const [start,end, weight] = v;
        map[start - 1][end - 1] = weight;
        map[end - 1][start - 1] = weight;
    })
    
   for(let k = 0; k < n; k++) { // 경
       for(let i = 0; i < n; i++) {//출
          for(let j = 0; j < n; j++) { // 도
              if(map[i][j] > map[i][k] + map[k][j]) map[i][j] = map[i][k] + map[k][j];
          }
       }
   } 
    let answer = map[s-1][a-1] + map[s-1][b-1];
    for(let i = 0; i < n; i++){
        answer = Math.min(answer, map[s-1][i] + map[i][a-1] + map[i][b-1]);
    }
    return answer;
  }