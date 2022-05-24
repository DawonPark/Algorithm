function solution(board, moves) {
    var answer = 0;
    const stack = [];
    for(let i=0; i<moves.length; i++){
        const idx = search(moves[i] - 1 , board[0].length, board);
        if(idx > 0){
            if(stack[stack.length -1] === idx){
                stack.pop();
                answer+=2;
            }else stack.push(idx);
        }
    }
    return answer;
}

function search(col, len, board){
    for(let i =0; i<len; i++){
        if(board[i][col] > 0) {
            const idx = board[i][col];
            board[i][col] = 0;
            return idx;
        }
    }
    return 0;
}