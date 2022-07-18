function solution(clothes) {
    var answer = 1;
    let map = {};
    for(let i = 0; i < clothes.length;  i++){
        if(map[clothes[i][1]]){
            map[clothes[i][1]]++;
        }else{
            map[clothes[i][1]] = 1;
        }
    }
    
    for(const el in map) answer*= map[el] + 1;
    
    return answer - 1;
}