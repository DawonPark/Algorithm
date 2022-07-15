function solution(gems) {
    const cnt = new Set(gems).size;
    let answer = [1, gems.length];
    
    const map = new Map();
    let l =0 , r = 0;
    map.set(gems[0] , 1);
    while(r < gems.length && l < gems.length){
        if(map.size === cnt){
            if(answer[1] - answer[0] > r - l) answer = [l + 1 , r + 1];
            
            if(map.get(gems[l]) === 1) {
                map.delete(gems[l]);
            }else {
                map.set(gems[l], map.get(gems[l]) - 1);
            }
            l++;
        }else {
            r++;
            if(map.has(gems[r])){
                map.set(gems[r] , map.get(gems[r]) + 1 );
            }else map.set(gems[r] , 1);
        }
    }
    
    return answer;
}