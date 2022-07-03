function solution(maps) {
    if(maps[maps.length-1][maps[0].length -2] === 0 && maps[maps.length-2][maps[0].length -1] === 0) return -1;
    var answer = 0;
    const queue =[];
    const visited = Array.from(new Array(maps.length) , ()=>new Array(maps[0].length).fill(false));
    let dx = [0,0,-1,1];
    let dy = [1,-1,0,0];
    queue.push([0,0]);
    visited[0][0] = true;
    let cnt = 1;
    while(queue.length){
        let size = queue.length;
        cnt++;
        for(let i =0; i<size; i++){
            let [x,y] = queue.shift();
            for(let d = 0; d<4; d++){
                let [nx, ny] = [x +dx[d] , y + dy[d]];
                if(nx < 0 || nx>= maps.length || ny<0 || ny>=maps[0].length) continue;
                if(nx === maps.length -1 && ny === maps[0].length -1) return cnt;
                if(maps[nx][ny] === 1 && !visited[nx][ny]) {
                    queue.push([nx,ny]);
                    visited[nx][ny] = true;
                }
            }
        }
    }


    return -1;
}