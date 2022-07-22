function solution(n, words) {
    let answer = [0, 0];
    const map = {};
    map[words[0]] = 1;
    for(let i = 1; i < words.length; i++){
        let [beforeWord, currentWord] = [words[i-1], words[i]];
        if(beforeWord[beforeWord.length -1] === currentWord[0] && !map[currentWord]){
            map[currentWord] = 1;
        }else{
            return answer =  [i% n +1 , Math.floor(i/n) +1]
        }
        
    }
    return answer;
}