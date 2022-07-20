function solution(m, n, board) {
    let answer = 0;
    let list = [];
    const map = board.map(v=> v.split(""));
    let cnt = 0;
    while(true){
        let check = false;
        list = [];
        for(let i = 0; i < m-1; i++){
            for(let j = 0; j < n-1; j++){
                if(map[i][j]!== '0' &&
                   map[i][j]=== map[i][j+1] &&
                   map[i][j]=== map[i+1][j] &&
                   map[i][j]=== map[i+1][j+1]) {
                    list.push([i,j]);
                    list.push([i,j+1]);
                    list.push([i+1,j]);
                    list.push([i+1,j+1]);
                    check = true;
                }
            }
        }
        
        if(!check) break;
       
        list.forEach(v => {
            const [x,y] = v;
            if(map[x][y] !== '0'){
                answer++;
                map[x][y] = '0';
            }
        })
        
        for(let i = 0; i < n; i++){
            for(let j = m-1; j >= 0; j--){
                if(map[j][i] === '0'){
                    let idx = j - 1;
                    while(idx >= 0){
                        if(map[idx][i] !== '0') break;
                        if(idx < 0) break;
                        idx--;
                    }
                    if(idx >= 0) {
                        map[j][i] = map[idx][i];
                        map[idx][i] = '0';
                    }
                }
            }
        }
        
    }

    
    return answer;
}