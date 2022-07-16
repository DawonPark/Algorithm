
function solution(s) {
    let map = { "]" :  "[" , "}" : "{" , ")" : "(" }
    let answer = 0;
    s = s.split("");
    const check = str => {
        const stack = [];
        for(let i = 0; i < str.length; i++){
            const ch = str[i];
            if(ch === "[" || ch === "{" || ch === "(") stack.push(ch);
            if(map[ch]) {
                if(map[ch] !== stack[stack.length -1]) return false;
                stack.pop();
            }
        }
        if(stack.length) return false;
        return true;
    }
    
    for(let i = 0; i < s.length; i++){
        if(check(s)) answer++;
        s.push(s.shift());
    }
    
    return answer;
}