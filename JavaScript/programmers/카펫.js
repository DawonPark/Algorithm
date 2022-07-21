function solution(brown, yellow) {
    var answer = [];
    let area = brown + yellow;
    
    for(let i = 1; i <= area; i++){
        let row = i;
        let col = Math.floor(area / i);
        if( row > col) continue;
        if((row - 2) * (col - 2) === yellow){
            return [col, row];
        }
    }
    
    return answer;
}