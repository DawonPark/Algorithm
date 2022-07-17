function solution(N, road, K) {
    
    let matrix = Array.from(Array(N+1), ()=> []);

    for(let i =0; i < road.length; i++){
        let [start,end,len] = road[i];
        matrix[start].push({end, len});
        matrix[end].push({end : start, len});
    }
    
    let dist = new Array(N + 1).fill(Infinity);
    let visited = new Array(N +1).fill(0);
    dist[1] = 0;

    
    for(let i = 0; i < N; i++){
        let val = Infinity;
        let index = 0;
        for(let j = 1; j <= N; j++){
            if(!visited[j] && dist[j] < val){
                val = dist[j];
                index = j;
            }
        }
        visited[index] = 1;
        
        matrix[index].forEach((v) =>{
            if(dist[v.end] > dist[index] + v.len){
                dist[v.end] = dist[index] + v.len;
            }
        })
    }
    
    return dist.filter(el => el<=K).length;
}